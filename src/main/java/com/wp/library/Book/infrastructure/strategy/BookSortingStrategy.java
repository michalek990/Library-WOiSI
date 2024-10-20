package com.wp.library.Book.infrastructure.strategy;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.constants.SortDirection;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public interface BookSortingStrategy {
    List<Book> sort(List<Book> books, SortDirection direction);

    default Comparator<Book> comparator(Function<Book, ? extends Comparable> comparing, SortDirection direction) {
        Comparator<Book> comparator = Comparator.comparing(comparing);
        return direction == SortDirection.ASC ? comparator : comparator.reversed();
    }
}
