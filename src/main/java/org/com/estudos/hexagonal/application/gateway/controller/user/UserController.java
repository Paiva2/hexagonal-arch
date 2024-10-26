package org.com.estudos.hexagonal.application.gateway.controller.user;

import jakarta.validation.Valid;
import org.com.estudos.hexagonal.application.gateway.input.RegisterUserInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterUserOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/user")
public interface UserController {
    @PostMapping("/register")
    ResponseEntity<RegisterUserOutput> register(@RequestBody @Valid RegisterUserInput input);
}
