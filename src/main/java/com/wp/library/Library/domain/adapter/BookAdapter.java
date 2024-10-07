package com.wp.library.Library.domain.adapter;

import com.wp.library.Library.domain.contract.BookRequest;
import com.wp.library.Library.domain.contract.BookResponse;

public interface BookAdapter {

    BookResponse createBook(BookRequest request);
}
