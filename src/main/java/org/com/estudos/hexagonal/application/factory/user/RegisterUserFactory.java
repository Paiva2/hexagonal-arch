package org.com.estudos.hexagonal.application.factory.user;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.domain.port.outbound.repository.UserRepositoryPort;
import org.com.estudos.hexagonal.domain.port.outbound.utils.EmailValidatorUtilsPort;
import org.com.estudos.hexagonal.domain.usecase.user.registerUser.RegisterUserUsecaseImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@AllArgsConstructor
@Configuration
public class RegisterUserFactory {
    private final UserRepositoryPort userRepositoryPort;
    private final EmailValidatorUtilsPort emailValidatorUtilsPort;

    @Bean("registerUserUsecase")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RegisterUserUsecaseImpl create() {
        return RegisterUserUsecaseImpl.builder()
            .userRepositoryPort(userRepositoryPort)
            .emailValidatorUtilsPort(emailValidatorUtilsPort)
            .build();
    }
}
