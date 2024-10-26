package org.com.estudos.hexagonal.domain.usecase.book.registerBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.com.estudos.hexagonal.application.gateway.input.RegisterBookInput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterBookOutput;
import org.com.estudos.hexagonal.domain.common.exception.UserNotRegisteredException;
import org.com.estudos.hexagonal.domain.entity.Book;
import org.com.estudos.hexagonal.domain.entity.User;
import org.com.estudos.hexagonal.domain.port.inbound.RegisterBookUsecase;
import org.com.estudos.hexagonal.domain.port.outbound.repository.BookRepositoryPort;
import org.com.estudos.hexagonal.domain.port.outbound.repository.UserRepositoryPort;
import org.com.estudos.hexagonal.domain.usecase.book.registerBook.exception.BookAlreadyRegisteredException;

import java.util.Calendar;
import java.util.Optional;

@AllArgsConstructor
@Builder
public class RegisterBookUsecaseImpl implements RegisterBookUsecase {
    private final BookRepositoryPort bookRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public RegisterBookOutput execute(RegisterBookInput input) {
        checkUserExists(input.getEmail());
        checkBookExists(input.getTitle());
        Book bookFilled = fillBook(input);
        bookFilled = persistBook(bookFilled);

        return mountOutput(bookFilled);
    }

    private void checkUserExists(String userEmail) {
        Optional<User> user = userRepositoryPort.findByEmail(userEmail);

        if (user.isEmpty()) {
            throw new UserNotRegisteredException("Only registered users can register books!");
        }
    }

    private void checkBookExists(String title) {
        Optional<Book> book = bookRepositoryPort.findByTitle(title);

        if (book.isPresent()) {
            throw new BookAlreadyRegisteredException("Book with title " + title + " already exists!");
        }
    }

    private Book fillBook(RegisterBookInput input) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(input.getReleasedAt());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return Book.builder()
            .title(input.getTitle().trim())
            .author(input.getAuthor().trim())
            .releasedAt(calendar.getTime())
            .build();
    }

    private Book persistBook(Book book) {
        return bookRepositoryPort.save(book);
    }

    private RegisterBookOutput mountOutput(Book book) {
        return RegisterBookOutput.builder()
            .id(book.getId())
            .title(book.getTitle())
            .author(book.getAuthor())
            .releasedAt(book.getReleasedAt())
            .build();
    }
}
