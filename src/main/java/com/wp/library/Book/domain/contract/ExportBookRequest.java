package com.wp.library.Book.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wp.library.Book.domain.constants.BookSortType;
import com.wp.library.Book.domain.constants.SortDirection;
import com.wp.library.shared.exporter.ExporterType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExportBookRequest {

    @NotNull(message = "formats of exported file")
    @JsonProperty("formats")
    private ExporterType[] formats;

    @NotNull(message = "sort types")
    @JsonProperty("sorts")
    private SortType[] sorts;

    @JsonProperty("toMail")
    private String toMail;

    public record SortType(
            BookSortType sortType,
            SortDirection direction
    ) { }
}
