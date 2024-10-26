package org.com.estudos.hexagonal.config;

import org.com.estudos.hexagonal.domain.common.exception.generic.BadRequestException;
import org.com.estudos.hexagonal.domain.common.exception.generic.ConflictException;
import org.com.estudos.hexagonal.domain.common.exception.generic.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, Object> error = mapErrors(
            e.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            e.getClass().getSimpleName()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> handleConflictException(ConflictException e) {
        Map<String, Object> error = mapErrors(
            e.getMessage(),
            HttpStatus.CONFLICT.value(),
            e.getClass().getSimpleName()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException e) {
        Map<String, Object> error = mapErrors(
            e.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            e.getClass().getSimpleName()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException e) {
        Map<String, Object> error = mapErrors(
            e.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            e.getClass().getSimpleName()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> mapErrors(String message, Integer statusCode, String exception) {
        return new LinkedHashMap<>() {{
            put("timestamp", new Date());
            put("message", message);
            put("status", statusCode);
            put("exception", exception);
        }};
    }
}
