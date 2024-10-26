package org.com.estudos.hexagonal.application.gateway.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterBookOutput {
    private Long id;
    private String title;
    private String author;
    private Date releasedAt;
}
