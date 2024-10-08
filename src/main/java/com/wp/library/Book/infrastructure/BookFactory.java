package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.book.Ebook;
import com.wp.library.Book.domain.book.PrintedBook;
import org.springframework.stereotype.Component;

@Component
class BookFactory {

    static Ebook createEbook(String title, String description, Integer rate, String isbn, String fileFormat) {
        return new Ebook(title, description, rate, isbn, fileFormat);
    }

    static PrintedBook createPrintedBook(String title, String description, Integer rate, String isbn, Integer numberOfPages) {
        return new PrintedBook(title, description, rate, isbn, numberOfPages);
    }
}
