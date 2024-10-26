package org.com.estudos.hexagonal.domain.port.inbound;

import org.com.estudos.hexagonal.application.gateway.input.RegisterBookInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterBookOutput;

public interface RegisterBookUsecase {
    RegisterBookOutput execute(RegisterBookInput input);
}
