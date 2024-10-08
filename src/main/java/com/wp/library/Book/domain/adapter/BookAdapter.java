package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.Ebook;
import com.wp.library.Book.domain.book.PrintedBook;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;

public interface BookAdapter {

    BookResponse createBook(BookRequest request);
    BookResponse createEbook(BookRequest request);
    BookResponse createPrintedBook(BookRequest request);
    BookResponse createCloneEbook(BookRequest request, Long existingEBookId);
    BookResponse createClonePrintedBook(BookRequest request, Long existingPrintedBookId);
}
