package list.handle.api.game.controllers;

import list.handle.api.game.models.GameInfoDTO;
import list.handle.api.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("/")
    public ResponseEntity<List<GameInfoDTO>> getAllGames() {
        return ResponseEntity.ok(service.getAllGames());
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<GameInfoDTO> getGame(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getGame(id));
    }

    @PostMapping("/game")
    public ResponseEntity<GameInfoDTO> createGame(@Validated @RequestBody GameInfoDTO game) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createGame(game));
    }

    @PutMapping("/game/{id}")
    public ResponseEntity<GameInfoDTO> updateGame(@PathVariable("id") String id, @RequestBody GameInfoDTO game) {
        game.setId(id);
        GameInfoDTO gameUpdated = service.updateGame(game);
        return gameUpdated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(gameUpdated);
    }

    @DeleteMapping("/game/{id}")
    public void delete(@PathVariable String id) {
        service.deleteGame(id);
    }

}