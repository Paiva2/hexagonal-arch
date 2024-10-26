package org.com.estudos.hexagonal.application.factory.book;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.domain.port.outbound.repository.BookRepositoryPort;
import org.com.estudos.hexagonal.domain.port.outbound.repository.UserRepositoryPort;
import org.com.estudos.hexagonal.domain.usecase.book.registerBook.RegisterBookUsecaseImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@AllArgsConstructor
@Configuration
public class RegisterBookFactory {
    private final BookRepositoryPort bookRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Bean("registerBookUsecase")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RegisterBookUsecaseImpl create() {
        return RegisterBookUsecaseImpl.builder()
            .bookRepositoryPort(bookRepositoryPort)
            .userRepositoryPort(userRepositoryPort)
            .build();
    }
}
