package org.com.estudos.hexagonal.adapter.mapper;

import org.com.estudos.hexagonal.adapter.persistence.entity.BookEntity;
import org.com.estudos.hexagonal.domain.entity.Book;
import org.springframework.beans.BeanUtils;

public class BookMapper {
    public static BookEntity toPersistence(Book bookDomain) {
        if (bookDomain == null) return null;

        BookEntity bookEntity = new BookEntity();
        copyProperties(bookDomain, bookEntity);

        return bookEntity;
    }

    public static Book toDomain(BookEntity bookEntity) {
        if (bookEntity == null) return null;

        Book book = new Book();
        copyProperties(bookEntity, book);

        return book;
    }

    private static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }
}
