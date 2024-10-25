package com.wp.library.Book.domain.memento;

import com.wp.library.Book.domain.book.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public record BookOriginator(Book book) {

    public BookMemento createMemento() {
        return new BookMemento(book.getTitle(), book.getDescription(), book.getRate(), book.getIsbn());
    }

    public void restoreFromMemento(BookMemento memento) {
        book.setTitle(memento.getTitle());
        book.setDescription(memento.getDescription());
        book.setRate(memento.getRate());
        book.setIsbn(memento.getIsbn());
    }
}
