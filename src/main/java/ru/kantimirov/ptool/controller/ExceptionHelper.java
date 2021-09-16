package ru.kantimirov.ptool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import ru.kantimirov.ptool.exception.InnerLogicRuntimeException;

@ControllerAdvice
public class ExceptionHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(value = {HttpClientErrorException.Unauthorized.class})
    public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        LOGGER.error("Unauthorized Exception: ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InnerLogicRuntimeException.class})
    public ResponseEntity<Object> handleException(InnerLogicRuntimeException ex) {
        LOGGER.error("InnerLogicRuntimeException: ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        LOGGER.error("Exception: ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
