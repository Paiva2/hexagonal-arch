package org.com.estudos.hexagonal.domain.common.exception;

import org.com.estudos.hexagonal.domain.common.exception.generic.NotFoundException;

public class UserNotRegisteredException extends NotFoundException {
    public UserNotRegisteredException(String message) {
        super(message);
    }
}
