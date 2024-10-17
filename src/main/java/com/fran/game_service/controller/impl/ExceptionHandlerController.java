package com.fran.game_service.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fran.game_service.commons.dto.ErrorResponse;
import com.fran.game_service.commons.exceptions.GameExceptions;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(value = {GameExceptions.class})
    ResponseEntity<ErrorResponse> handleError(GameExceptions gameException) {
        log.error("new Exception", gameException);
        var errorResponse = ErrorResponse.builder()
        .codeStatus(gameException.getHttpStatus().value())
        .message(gameException.getMessage())
        .build();

        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse);
    }
}
