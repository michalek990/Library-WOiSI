package com.wp.library.Book.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest implements Serializable {

    @NotNull(message = "title cannot be null")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "description cannot be null")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "rate cannot be null")
    @JsonProperty("rate")
    private Integer rate;

    @NotNull(message = "isbn cannot be null")
    @JsonProperty("isbn")
    private String isbn;

    @NotNull(message = "additionalAttribute cannot be null")
    @JsonProperty("additionalAttribute")
    private String additionalAttribute;
}
