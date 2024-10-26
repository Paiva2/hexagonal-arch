package org.com.estudos.hexagonal.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private Long id;
    private String title;
    private String author;
    private Date releasedAt;
}
