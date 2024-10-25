package com.wp.library.Book.domain.book.state;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.BookState;

public class BorrowedState implements BookState {
    @Override
    public void borrow(Book book) {
        System.out.println("The book is already borrowed.");
    }

    @Override
    public void returnBook(Book book) {
        book.setState(new AvailableState());
        System.out.println("The book has been returned and is now available.");
    }

    @Override
    public void reserve(Book book) {
        System.out.println("The book is already borrowed and cannot be reserved.");
    }

    @Override
    public void archive(Book book) {
        System.out.println("The book is borrowed and cannot be archived.");
    }
}
