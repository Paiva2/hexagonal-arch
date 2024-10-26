package org.com.estudos.hexagonal.application.gateway.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserInput {
    @NotBlank(message = "Name can't be empty or null")
    private String name;

    @NotBlank(message = "Name can't be empty or null")
    private String email;
}
