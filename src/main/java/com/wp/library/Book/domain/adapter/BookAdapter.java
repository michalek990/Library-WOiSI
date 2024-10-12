package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;

public interface BookAdapter {
    BookResponse createBook(BookRequest request);
    BookResponse createEbook(BookRequest request);
    BookResponse createPrintedBook(BookRequest request);
    BookResponse createCloneEbook(BookRequest request, Long existingEBookId);
    BookResponse createClonePrintedBook(BookRequest request, Long existingPrintedBookId);
}
