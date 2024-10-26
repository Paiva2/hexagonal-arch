package org.com.estudos.hexagonal.domain.port.inbound;

import org.com.estudos.hexagonal.application.gateway.input.RegisterUserInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterUserOutput;

public interface RegisterUserUsecase {
    RegisterUserOutput execute(RegisterUserInput input);
}
