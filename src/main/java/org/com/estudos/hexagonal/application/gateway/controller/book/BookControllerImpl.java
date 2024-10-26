package org.com.estudos.hexagonal.application.gateway.controller.book;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.application.gateway.input.RegisterBookInput;
import org.com.estudos.hexagonal.application.gateway.output.ListAllBooksOutput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterBookOutput;
import org.com.estudos.hexagonal.domain.port.inbound.ListAllBooksUsecase;
import org.com.estudos.hexagonal.domain.port.inbound.RegisterBookUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookControllerImpl implements BookController {
    private final RegisterBookUsecase registerBookUsecase;
    private final ListAllBooksUsecase listAllBooksUsecase;

    @Override
    public ResponseEntity<RegisterBookOutput> register(RegisterBookInput input) {
        RegisterBookOutput output = registerBookUsecase.execute(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ListAllBooksOutput> listAll(int page, int size, String title) {
        ListAllBooksOutput output = listAllBooksUsecase.execute(page, size, title);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
