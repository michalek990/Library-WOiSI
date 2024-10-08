package com.wp.library.Book.interfaces;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Book.domain.contract.resource.BookResource;
import com.wp.library.Book.infrastructure.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController implements BookResource {

    private final BookService bookService;

    @Override
    public BookResponse crateBook(@RequestBody BookRequest request) {
        return bookService.createBook(request);
    }

    @Override
    public BookResponse crateEbook(@RequestBody BookRequest request) {
        return bookService.createEbook(request);
    }

    @Override
    public BookResponse cratePrintedBook(@RequestBody BookRequest request) {
        return bookService.createPrintedBook(request);
    }

    @Override
    public ResponseEntity<byte[]> exportBooks(ExportBookRequest request) {
        ExportBookResponse response = bookService.exportBook(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + response.fileName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(response.content());
    }
}
