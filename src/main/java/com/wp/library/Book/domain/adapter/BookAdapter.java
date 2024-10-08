package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;

public interface BookAdapter {

    BookResponse createBook(BookRequest request);
}
