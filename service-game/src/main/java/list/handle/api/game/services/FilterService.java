package list.handle.api.game.services;

import list.handle.api.game.models.GameInfoDTO;

import java.util.List;

public interface FilterService {
    List<String> getAllPlatforms();

    List<String> getAllPegis();

    List<GameInfoDTO> listGames(String platform, String pegi);
}
