package list.handle.api.game.services;

import list.handle.api.game.models.GameInfoDTO;
import list.handle.api.game.repositories.IGameInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private IGameInfoDAO repository;

    @Override
    public List<GameInfoDTO> getAllGames() {
        return repository.findAll();
    }

    @Override
    public GameInfoDTO getGame(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public GameInfoDTO createGame(GameInfoDTO gameInfo) {
        return repository.insert(gameInfo);
    }

    @Override
    public GameInfoDTO updateGame(GameInfoDTO gameInfo) {
        return repository.save(fillGameInfo(repository.findById(gameInfo.getId()).orElse(null), gameInfo));
    }

    @Override
    public void deleteGame(String id) {
        repository.deleteById(id);
    }

    GameInfoDTO fillGameInfo(GameInfoDTO updatedGame, GameInfoDTO gameInfo){
        updatedGame.setName(gameInfo.getName() == null ? updatedGame.getName() : gameInfo.getName());
        updatedGame.setPlatform(gameInfo.getPlatform() == null ? updatedGame.getPlatform() : gameInfo.getPlatform());
        return updatedGame;
    }
}
