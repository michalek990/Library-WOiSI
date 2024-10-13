package com.wp.library.Book.infrastructure.strategy;

import com.wp.library.Book.domain.constants.BookSortType;

import java.util.HashMap;
import java.util.Map;

public class BookSortingStrategyFactory {
    private static final Map<BookSortType, BookSortingStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put(BookSortType.TITLE, new TitleSortingStrategy());
        STRATEGY_MAP.put(BookSortType.DESCRIPTION, new DescriptionSortingStrategy());
        STRATEGY_MAP.put(BookSortType.RATING, new RatingSortingStrategy());
        STRATEGY_MAP.put(BookSortType.ISBN, new IsbnSortingStrategy());
    }

    public static BookSortingStrategy getStrategy(BookSortType bookSortType) {
        return STRATEGY_MAP.get(bookSortType);
    }
}
