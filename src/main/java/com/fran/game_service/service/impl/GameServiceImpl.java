package com.fran.game_service.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fran.game_service.commons.entities.Game;
import com.fran.game_service.commons.exceptions.GameExceptions;
import com.fran.game_service.repositories.GameRepository;
import com.fran.game_service.service.GameService;

@Service
public class GameServiceImpl implements GameService {
    
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) { 
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game game) { 
        Game savedGame = this.gameRepository.save(game);
        return savedGame;
    }

    @Override
    public Game getGame(Long gameId) { 
        return this.gameRepository.findById(gameId)
        .orElseThrow(() -> new GameExceptions(HttpStatus.NOT_FOUND, "Error game not found"));
    }

    @Override
    public Game putGame(Long gameId, Game newGame) { 
        Game gameToUpdate = this.gameRepository.findById(gameId)
        .orElseThrow(() -> new GameExceptions(HttpStatus.NOT_FOUND, "Error findnig game"));

      
        Game game = gameToUpdate.get();
        game.setName(newGame.getName());

        return this.gameRepository.save(game);
    }
    
    @Override
    public void deleteGame(Long gameId) {
        this.gameRepository.deleteById(gameId);
    }
}
