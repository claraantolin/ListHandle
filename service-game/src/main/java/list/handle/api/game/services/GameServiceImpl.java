package list.handle.api.game.services;

import list.handle.api.game.models.GameInfoDTO;
import list.handle.api.game.repositories.IGameInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private IGameInfoDAO repository;

    @Autowired
    MongoTemplate mongoTemplate;

    final String INCREASE = "INCREASE";
    final String REDUCE = "REDUCE";

    @Override
    public List<GameInfoDTO> getAllGames() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "position")); }

    @Override
    public GameInfoDTO getGame(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public GameInfoDTO createGame(GameInfoDTO gameInfo) {
        gameInfo.setPosition((int) repository.count() +1);
        return repository.insert(gameInfo);
    }

    @Override
    public GameInfoDTO updateGame(GameInfoDTO gameInfo) {
        return repository.save(fillGameInfo(repository.findById(gameInfo.getId()).orElse(null), gameInfo));
    }

    @Override
    public GameInfoDTO updatePositionGame(String id, int newPosition) {
        GameInfoDTO game = repository.findById(id).orElse(null);
        int from = game.getPosition();
        GameInfoDTO positionInfo = new GameInfoDTO();
        Query query = new Query();
        String operation = "";

        if (from > newPosition)
            query.addCriteria(Criteria.where("position").gte(newPosition).lt(from));
        else if (from < newPosition)
            query.addCriteria(Criteria.where("position").gt(from).lte(newPosition));

        List<GameInfoDTO> games = mongoTemplate.find(query,GameInfoDTO.class);
        updatePositionGames(games, from > newPosition ? INCREASE : REDUCE);
        positionInfo.setPosition(newPosition);
        return repository.save(fillGameInfo(game, positionInfo));
    }

    @Override
    public void deleteGame(String id) {
        int position = repository.findById(id).orElse(null).getPosition();
        repository.deleteById(id);
        Query query = new Query();
        query.addCriteria(Criteria.where("position").gt(position));
        updatePositionGames(mongoTemplate.find(query,GameInfoDTO.class), REDUCE);
    }

    @Override
    public void deleteAllGames() {
        repository.deleteAll();
    }

    @Override
    public List<GameInfoDTO> generateGames(){
        deleteAllGames();
        int amount = 10;
        while(amount > 0){
            GameInfoDTO game = new GameInfoDTO();
            game.setPosition(amount);
            game.setName("Juego " + amount);
            game.setPegi("pegi");
            game.setPlatform("platform");
            repository.insert(game);
            amount--;
        }
        return getAllGames();
    }

    GameInfoDTO fillGameInfo(GameInfoDTO updatedGame, GameInfoDTO gameInfo){
        updatedGame.setPosition(gameInfo.getPosition());
        updatedGame.setName(gameInfo.getName() == null ? updatedGame.getName() : gameInfo.getName());
        updatedGame.setPlatform(gameInfo.getPlatform() == null ? updatedGame.getPlatform() : gameInfo.getPlatform());
        updatedGame.setPegi(gameInfo.getPegi() == null ? updatedGame.getPegi() : gameInfo.getPegi());
        return updatedGame;
    }

    void updatePositionGames(List<GameInfoDTO> games, String operation) {
        games.stream().map(item -> {
            GameInfoDTO posInfo = new GameInfoDTO();
            posInfo.setPosition(operation.equals(INCREASE) ? item.getPosition() + 1 : item.getPosition() - 1);
            return fillGameInfo(item, posInfo);
        }).collect(Collectors.toList()).forEach((item) -> {
            repository.save(item);
        });
    }
}
