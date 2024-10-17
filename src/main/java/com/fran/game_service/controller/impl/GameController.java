package com.fran.game_service.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fran.game_service.commons.entities.Game;
import com.fran.game_service.controller.GameApi;
import com.fran.game_service.service.GameService;


@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) { 
        this.gameService = gameService;
    }
    
    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game) { 
        Game cratedGame = this.gameService.saveGame(game);
        return ResponseEntity.ok(cratedGame);
    
    }

    @Override
    public ResponseEntity<Game> getGame(@PathVariable Long gameId) { 
        Game gameObtained = this.gameService.getGame(gameId);
        return ResponseEntity.ok(gameObtained);
    }

    @Override
    public ResponseEntity<Game> putMethodName(@PathVariable Long gameId, @RequestBody Game game) {       
        Game updatedGgame = this.gameService.putGame(gameId, game);
        return ResponseEntity.ok(updatedGgame);
    }

    @Override
    public ResponseEntity<Object> deleteMethodName(@PathVariable Long gameId) {       
        this.gameService.deleteGame(gameId);
   
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
