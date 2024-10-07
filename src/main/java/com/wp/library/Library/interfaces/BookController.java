package com.wp.library.Library.interfaces;

import com.wp.library.Library.domain.contract.BookRequest;
import com.wp.library.Library.domain.contract.BookResponse;
import com.wp.library.Library.domain.contract.resource.BookResource;
import com.wp.library.Library.infrastructure.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
