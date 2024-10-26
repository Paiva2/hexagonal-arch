package org.com.estudos.hexagonal.domain.usecase.book.registerBook.exception;

import org.com.estudos.hexagonal.domain.common.exception.generic.ConflictException;

public class BookAlreadyRegisteredException extends ConflictException {
    public BookAlreadyRegisteredException(String message) {
        super(message);
    }
}
