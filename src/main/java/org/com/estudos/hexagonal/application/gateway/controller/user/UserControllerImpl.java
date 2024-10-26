package org.com.estudos.hexagonal.application.gateway.controller.user;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.application.gateway.input.RegisterUserInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterUserOutput;
import org.com.estudos.hexagonal.domain.port.inbound.RegisterUserUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final RegisterUserUsecase registerUserUsecase;

    @Override
    public ResponseEntity<RegisterUserOutput> register(RegisterUserInput input) {
        RegisterUserOutput output = registerUserUsecase.execute(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }
}
