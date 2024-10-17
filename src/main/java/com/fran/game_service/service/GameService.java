package com.fran.game_service.service;

import com.fran.game_service.commons.entities.Game;

public interface GameService {
    public Game saveGame(Game game);

    public Game getGame(Long gameId);

    public Game putGame(Long gameId, Game newGame);

    public void deleteGame(Long gameId);
}
