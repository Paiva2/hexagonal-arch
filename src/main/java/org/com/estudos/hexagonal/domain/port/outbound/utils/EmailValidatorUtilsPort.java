package org.com.estudos.hexagonal.domain.port.outbound.utils;

import org.com.estudos.hexagonal.domain.common.exception.InvalidEmailException;

public interface EmailValidatorUtilsPort {
    void validate(String email) throws InvalidEmailException;
}
