package com.wp.library.Book.domain.book.state;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.BookState;

public class AvailableState implements BookState {
    @Override
    public void borrow(Book book) {
        book.setState(new BorrowedState());
        System.out.println("The book has been borrowed.");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("The book is already available and cannot be returned.");
    }

    @Override
    public void reserve(Book book) {
        book.setState(new ReservedState());
        System.out.println("The book has been reserved.");
    }

    @Override
    public void archive(Book book) {
        book.setState(new ArchivedState());
        System.out.println("The book has been archived.");
    }
}
