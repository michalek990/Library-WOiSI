package com.wp.library.Book.infrastructure.strategy;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.constants.SortDirection;

import java.util.List;

class DescriptionSortingStrategy implements BookSortingStrategy {

    @Override
    public List<Book> sort(List<Book> books, SortDirection direction) {
        return books.stream()
                .sorted(comparator(Book::getDescription, direction))
                .toList();
    }
}
