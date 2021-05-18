package list.handle.api.game.repositories;

import list.handle.api.game.models.GameInfoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameInfoDAO extends MongoRepository<GameInfoDTO, String> {

}
