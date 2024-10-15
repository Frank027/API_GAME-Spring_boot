package com.fran.game_service.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fran.game_service.entities.Game;
import com.fran.game_service.repositories.GameRepository;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) { 
        this.gameRepository = gameRepository;
    }

    public Game saveGame(Game game) { 
        Game savedGame = this.gameRepository.save(game);
        return savedGame;
    }

    public Object getGame(Long gameId) { 
        Optional<Game> game = this.gameRepository.findById(gameId);

        if (game.isPresent()) {
            return game;
        }
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El juego no existe");
        return response;
    }

    public Object putGame(Long gameId, Game newGame) { 
        Optional<Game> gameToUpdate = this.gameRepository.findById(gameId);

        if (gameToUpdate.isPresent()) { 
            Game game = gameToUpdate.get();
            game.setName(newGame.getName());

            return this.gameRepository.save(game);
        }

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "El juego no existe");
        return response; 
    }

    public void deleteGame(Long gameId) {
        this.gameRepository.deleteById(gameId);
    }
}
