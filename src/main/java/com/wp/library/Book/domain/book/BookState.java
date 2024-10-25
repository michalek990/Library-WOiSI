package com.wp.library.Book.domain.book;

public interface BookState {
    void borrow(Book book);
    void returnBook(Book book);
    void reserve(Book book);
    void archive(Book book);
}