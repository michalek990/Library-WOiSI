package com.wp.library.Book.interfaces;

import com.wp.library.Book.domain.constants.BookType;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Book.domain.contract.resource.BookResource;
import com.wp.library.Book.infrastructure.LibraryService;
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

    private final LibraryService libraryService;

    @Override
    public BookResponse createBook(@RequestBody BookRequest request) {
        return libraryService.createBook(request, BookType.GENERIC_BOOK);
    }

    @Override
    public BookResponse createEbook(@RequestBody BookRequest request) {
        return libraryService.createBook(request, BookType.EBOOK);
    }

    @Override
    public BookResponse createPrintedBook(@RequestBody BookRequest request) {
        return libraryService.createBook(request,BookType.PRINTED_BOOK);
    }

    @Override
    public BookResponse createCloneEbook(@RequestBody BookRequest request, Long existingEBookId) {
        return libraryService.cloneBook(request, existingEBookId, BookType.EBOOK);
    }

    @Override
    public BookResponse createClonePrintedBook(@RequestBody BookRequest request, Long existingPrintedBookId) {
        return libraryService.cloneBook(request, existingPrintedBookId, BookType.PRINTED_BOOK);
    }
  
    @Override
    public ResponseEntity<byte[]> exportBooks(@RequestBody ExportBookRequest request) {
        ExportBookResponse response = libraryService.exportBook(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + response.fileName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(response.content());
    }
}
