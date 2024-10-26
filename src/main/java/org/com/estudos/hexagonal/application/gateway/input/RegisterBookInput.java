package org.com.estudos.hexagonal.application.gateway.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterBookInput {
    @NotBlank(message = "email can't be blank or null")
    private String email;

    @NotBlank(message = "title can't be blank or null")
    private String title;

    @NotBlank(message = "author can't be blank or null")
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releasedAt;
}
