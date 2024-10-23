package com.wp.library.Book.domain.book.state;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.BookState;

public class NewState implements BookState {
    @Override
    public void borrow(Book book) {
        System.out.println("The book is new and cannot be borrowed yet.");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("The book is new and has not been borrowed.");
    }

    @Override
    public void reserve(Book book) {
        System.out.println("The book is new and cannot be reserved yet.");
    }

    @Override
    public void archive(Book book) {
        book.setState(new ArchivedState());
        System.out.println("The book has been archived.");
    }
}