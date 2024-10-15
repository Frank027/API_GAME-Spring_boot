package com.fran.game_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fran.game_service.entities.Game;
import com.fran.game_service.service.GameService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) { 
        this.gameService = gameService;
    }
    
    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game) { 
        Game cratedGame = this.gameService.saveGame(game);
        return ResponseEntity.ok(cratedGame);
    
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Object> getGame(@PathVariable Long gameId) { 
        Object gameObtained = this.gameService.getGame(gameId);
        return ResponseEntity.ok(gameObtained);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable Long gameId, @RequestBody Game game) {       
        Object updatedGgame = this.gameService.putGame(gameId, game);
        return ResponseEntity.ok(updatedGgame);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Object> putMethodName(@PathVariable Long gameId) {       
        this.gameService.deleteGame(gameId);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Juego eliminado");
        return ResponseEntity.ok(response);
    }

}
