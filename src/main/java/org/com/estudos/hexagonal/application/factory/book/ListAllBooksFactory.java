package org.com.estudos.hexagonal.application.factory.book;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.domain.port.outbound.repository.BookRepositoryPort;
import org.com.estudos.hexagonal.domain.usecase.book.listAllBooks.ListAllBooksUsecaseImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@AllArgsConstructor
@Configuration
public class ListAllBooksFactory {
    private final BookRepositoryPort bookRepositoryPort;

    @Bean("listAllBooksUsecase")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ListAllBooksUsecaseImpl create() {
        return ListAllBooksUsecaseImpl.builder()
            .bookRepositoryPort(bookRepositoryPort)
            .build();
    }
}
