package org.com.estudos.hexagonal.adapter.persistence.repository.book;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.adapter.mapper.BookMapper;
import org.com.estudos.hexagonal.adapter.persistence.entity.BookEntity;
import org.com.estudos.hexagonal.domain.entity.Book;
import org.com.estudos.hexagonal.domain.port.outbound.repository.BookRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class BookRepositoryAdapter implements BookRepositoryPort {
    private final BookRepository bookRepository;

    @Override
    public Optional<Book> findByTitle(String title) {
        Optional<BookEntity> bookEntity = bookRepository.findByTitle(title);
        if (bookEntity.isEmpty()) return Optional.empty();
        return Optional.of(BookMapper.toDomain(bookEntity.get()));
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = bookRepository.save(BookMapper.toPersistence(book));
        return BookMapper.toDomain(bookEntity);
    }

    @Override
    public Page<Book> findAllBooks(Pageable pageable, String title) {
        Page<BookEntity> booksPage = bookRepository.findAllFiltering(pageable, title);
        return booksPage.map(BookMapper::toDomain);
    }
}
