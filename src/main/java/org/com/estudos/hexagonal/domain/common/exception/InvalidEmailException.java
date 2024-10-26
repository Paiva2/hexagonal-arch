package org.com.estudos.hexagonal.domain.common.exception;

import org.com.estudos.hexagonal.domain.common.exception.generic.BadRequestException;

public class InvalidEmailException extends BadRequestException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
