package com.wp.library.Book.domain.book.state;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.BookState;

public class ReservedState implements BookState {
    @Override
    public void borrow(Book book) {
        System.out.println("The book is reserved and cannot be borrowed.");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("The book is reserved and cannot be returned.");
    }

    @Override
    public void reserve(Book book) {
        System.out.println("The book is already reserved.");
    }

    @Override
    public void archive(Book book) {
        book.setState(new ArchivedState());
        System.out.println("The reserved book has been archived.");
    }
}