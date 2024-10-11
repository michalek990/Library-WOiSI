package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.BookAdapter;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class BookServiceLoggingProxy implements BookAdapter {
    private final BookService bookService;

    @Override
    public BookResponse createBook(BookRequest request) {
        log.info("Creating book");
        BookResponse response = bookService.createBook(request);
        log.info("Book created");
        return response;
    }

    @Override
    public BookResponse createEbook(BookRequest request) {
        log.info("Creating ebook");
        BookResponse response = bookService.createEbook(request);
        log.info("Ebook created");
        return response;
    }

    @Override
    public BookResponse createPrintedBook(BookRequest request) {
        log.info("Creating printed book");
        BookResponse response = bookService.createPrintedBook(request);
        log.info("Printed book created");
        return response;
    }

    @Override
    public BookResponse createCloneEbook(BookRequest request, Long existingEBookId) {
        log.info("Creating clone book");
        BookResponse response = bookService.createCloneEbook(request, existingEBookId);
        log.info("Clone book created");
        return response;
    }

    @Override
    public BookResponse createClonePrintedBook(BookRequest request, Long existingPrintedBookId) {
        log.info("Creating clone printed book");
        BookResponse response = bookService.createClonePrintedBook(request, existingPrintedBookId);
        log.info("Clone printed book created");
        return response;
    }

}
