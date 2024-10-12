package com.wp.library.Book.domain.constants;

public enum BookType {
    EBOOK("EBOOK"),
    PRINTED_BOOK("PRINTED_BOOK"),
    GENERIC_BOOK("BOOK");

    private final String type;

    BookType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
