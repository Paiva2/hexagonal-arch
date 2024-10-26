package org.com.estudos.hexagonal.domain.common.exception.generic;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
