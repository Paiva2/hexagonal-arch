package org.com.estudos.hexagonal.adapter.utils;

import org.com.estudos.hexagonal.domain.common.exception.InvalidEmailException;
import org.com.estudos.hexagonal.domain.port.outbound.utils.EmailValidatorUtilsPort;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidatorAdapter implements EmailValidatorUtilsPort {
    private final static Pattern regexEmailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void validate(String email) throws InvalidEmailException {
        Matcher matcher = regexEmailPattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException("Invalid e-mail!");
        }
    }
}
