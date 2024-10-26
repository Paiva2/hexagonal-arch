package org.com.estudos.hexagonal.domain.common.exception.generic;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
