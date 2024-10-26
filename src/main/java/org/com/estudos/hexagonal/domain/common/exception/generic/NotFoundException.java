package org.com.estudos.hexagonal.domain.common.exception.generic;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
