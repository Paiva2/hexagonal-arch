package org.com.estudos.hexagonal.domain.port.outbound.repository;

import org.com.estudos.hexagonal.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookRepositoryPort {
    Optional<Book> findByTitle(String title);

    Book save(Book book);

    Page<Book> findAllBooks(Pageable pageable, String title);
}
