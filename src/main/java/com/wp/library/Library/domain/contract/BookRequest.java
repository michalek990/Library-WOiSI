package com.wp.library.Library.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
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
    private Long rate;

    @NotNull(message = "isbn cannot be null")
    @JsonProperty("isbn")
    private Long isbn;
}
