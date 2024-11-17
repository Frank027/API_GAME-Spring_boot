package com.fran.game_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fran.game_service.commons.constans.ApiPathVariables;
import com.fran.game_service.commons.entities.Game;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game);

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@RequestHeader("userIdRequest") String userId, @PathVariable Long gameId);

    @PutMapping("/{id}")
    public ResponseEntity<Game> putMethodName(@RequestHeader("userIdRequest") String userId, @PathVariable Long gameId, @RequestBody Game game);

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Object> deleteMethodName(@RequestHeader("userIdRequest") String userId, @PathVariable Long gameId);
}
