package org.com.estudos.hexagonal.application.gateway.controller.book;

import jakarta.validation.Valid;
import org.com.estudos.hexagonal.application.gateway.input.RegisterBookInput;
import org.com.estudos.hexagonal.application.gateway.output.ListAllBooksOutput;
import org.com.estudos.hexagonal.application.gateway.output.RegisterBookOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/book")
public interface BookController {
    @PostMapping("/new")
    ResponseEntity<RegisterBookOutput> register(@RequestBody @Valid RegisterBookInput input);

    @GetMapping("/list")
    ResponseEntity<ListAllBooksOutput> listAll(
        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
        @RequestParam(value = "size", required = false, defaultValue = "5") int size,
        @RequestParam(required = false) String title
    );
}
