package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.constants.BookType;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;

public interface LibraryAdapter {

    BookResponse createBook(BookRequest request, BookType bookType);
    BookResponse cloneBook(BookRequest request, Long existingBookId, BookType bookType);
    ExportBookResponse exportBook(ExportBookRequest request);
}
