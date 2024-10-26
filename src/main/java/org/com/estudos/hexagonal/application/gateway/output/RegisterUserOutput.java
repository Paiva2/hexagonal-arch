package org.com.estudos.hexagonal.application.gateway.output;

import lombok.*;

@Getter
@Setter
@Builder
public class RegisterUserOutput {
    private Long id;
    private String name;
    private String email;
}
