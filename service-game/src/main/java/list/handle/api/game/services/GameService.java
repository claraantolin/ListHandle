package list.handle.api.game.services;

import list.handle.api.game.models.GameInfoDTO;

import java.util.List;

public interface GameService {

    List<GameInfoDTO> getAllGames();

    GameInfoDTO getGame(String id);

    GameInfoDTO createGame(GameInfoDTO gameInfo);

    GameInfoDTO updateGame(GameInfoDTO gameInfo);

    void deleteGame(String id);

}
