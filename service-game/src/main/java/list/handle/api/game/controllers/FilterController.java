package list.handle.api.game.controllers;

import list.handle.api.game.models.GameInfoDTO;
import list.handle.api.game.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api/filter")
public class FilterController {

    @Autowired
    private FilterService service;

    @GetMapping("/platforms")
    public ResponseEntity<List<String>> getAllPlatforms() {
        return ResponseEntity.ok(service.getAllPlatforms());
    }

    @GetMapping("/pegis")
    public ResponseEntity<List<String>> getAllPegis() {
        return ResponseEntity.ok(service.getAllPegis());
    }

    @GetMapping("/game")
    public ResponseEntity<List<GameInfoDTO>> listGames(@RequestParam(value = "platform", required = false) String platform, @RequestParam(value = "pegi", required = false) String pegi) {
        return ResponseEntity.ok(service.listGames(platform, pegi));
    }
}
