package com.fran.game_service.commons.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class GameExceptions extends RuntimeException {
    private HttpStatus httpStatus;
    
    
    public GameExceptions(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
