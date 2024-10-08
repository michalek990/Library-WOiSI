package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;

public interface BookAdapter {

    BookResponse createBook(BookRequest request);
    ExportBookResponse exportBook(ExportBookRequest request);
}
