package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.book.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BookCollection implements Iterable<Book> {
    private List<Book> books = new ArrayList<>();

    // Dodawanie książek do kolekcji
    public void addBook(Book book) {
        books.add(book);
    }

    // Implementacja metody iterator
    @Override
    public Iterator<Book> iterator() {
        return new BookIterator();
    }

    // Klasa iterująca po książkach
    private class BookIterator implements Iterator<Book> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            if (hasNext()) {
                return books.get(index++);
            }
            throw new NoSuchElementException("No more books in the collection");
        }
    }
}
