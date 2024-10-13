package com.wp.library.Book.domain.contract.resource;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.wp.library.shared.ApplicationMappings.BOOK_URL;

public interface BookResource {

    String EBOOK_URL = "/ebook";
    String PRINTED_BOOK = "/printed-book";
    String CLONE_EBOOK_URL = "/clone/ebook";
    String CLONE_PRINTED_URL = "/clone/printed-book";
    String EXPORT_BOOKS = "/export-books";

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
    BookResponse createBook(@Valid BookRequest request);

    @PostMapping(EBOOK_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new ebook")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creating new ebook",
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
    BookResponse createEbook(@Valid BookRequest request);

    @PostMapping(PRINTED_BOOK)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new printed book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creating new printed book",
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
    BookResponse createPrintedBook(@Valid BookRequest request);

  @PostMapping(CLONE_EBOOK_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new clone of ebook")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creating new clone of ebook",
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
    BookResponse createCloneEbook(@Valid BookRequest request, Long existingEBookId);

    @PostMapping(CLONE_PRINTED_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new clone of printed book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creating new clone of printed book",
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
    BookResponse createClonePrintedBook(@Valid BookRequest request, Long existingPrintedBookId);
              
    @GetMapping(EXPORT_BOOKS)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Exports books to file")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful exported books",
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
    ResponseEntity<byte[]> exportBooks(@Valid ExportBookRequest request);
}
