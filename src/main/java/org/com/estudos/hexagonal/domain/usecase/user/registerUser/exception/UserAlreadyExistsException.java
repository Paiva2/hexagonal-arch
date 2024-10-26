package org.com.estudos.hexagonal.domain.usecase.user.registerUser.exception;

import org.com.estudos.hexagonal.domain.common.exception.generic.ConflictException;

public class UserAlreadyExistsException extends ConflictException {
    private final static String MESSAGE = "User already registered!";

    public UserAlreadyExistsException() {
        super(MESSAGE);
    }
}
