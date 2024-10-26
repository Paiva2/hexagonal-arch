package org.com.estudos.hexagonal.application.gateway.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.estudos.hexagonal.domain.entity.Book;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ListAllBooksOutput {
    private Integer page;
    private Integer size;
    private Long totalItems;
    private Integer totalPages;
    private Boolean isLastPage;
    private List<BookOutput> books;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class BookOutput {
        private Long id;
        private String title;
        private String author;
        private Date releasedAt;

        public BookOutput(Book book) {
            this.id = book.getId();
            this.title = book.getTitle();
            this.author = book.getAuthor();
            this.releasedAt = book.getReleasedAt();
        }
    }
}
