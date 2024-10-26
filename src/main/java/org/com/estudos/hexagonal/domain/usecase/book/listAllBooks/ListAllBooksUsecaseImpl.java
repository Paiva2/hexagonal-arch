package org.com.estudos.hexagonal.domain.usecase.book.listAllBooks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.com.estudos.hexagonal.application.gateway.output.ListAllBooksOutput;
import org.com.estudos.hexagonal.domain.entity.Book;
import org.com.estudos.hexagonal.domain.port.inbound.ListAllBooksUsecase;
import org.com.estudos.hexagonal.domain.port.outbound.repository.BookRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@Builder
public class ListAllBooksUsecaseImpl implements ListAllBooksUsecase {
    private final BookRepositoryPort bookRepositoryPort;

    @Override
    public ListAllBooksOutput execute(int page, int size, String title) {
        if (page < 1) {
            page = 1;
        }

        if (size > 50) {
            size = 50;
        } else if (size < 5) {
            size = 5;
        }

        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.ASC, "title");
        Page<Book> booksPage = bookRepositoryPort.findAllBooks(pageable, title);

        return mountOutput(booksPage);
    }

    private ListAllBooksOutput mountOutput(Page<Book> books) {
        return ListAllBooksOutput.builder()
            .page(books.getNumber() + 1)
            .size(books.getSize())
            .totalItems(books.getTotalElements())
            .totalPages(books.getTotalPages())
            .isLastPage(books.isLast())
            .books(books.stream().map(ListAllBooksOutput.BookOutput::new).toList())
            .build();
    }
}
