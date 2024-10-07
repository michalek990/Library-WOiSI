package com.wp.library.Library.domain.contract.resource;

import com.wp.library.Library.domain.contract.BookRequest;
import com.wp.library.Library.domain.contract.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.wp.library.shared.ApplicationMappings.BOOK_URL;

public interface BookResource {

    String JSON = MediaType.APPLICATION_JSON_VALUE;

    @PostMapping(BOOK_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creating new book",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = BookResponse.class))),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentication failed",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
    })
    BookResponse crateBook(@Valid BookRequest request);
}
