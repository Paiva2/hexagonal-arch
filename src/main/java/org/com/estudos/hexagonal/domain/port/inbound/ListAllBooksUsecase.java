package org.com.estudos.hexagonal.domain.port.inbound;

import org.com.estudos.hexagonal.application.gateway.output.ListAllBooksOutput;

public interface ListAllBooksUsecase {
    ListAllBooksOutput execute(int page, int size, String title);
}
