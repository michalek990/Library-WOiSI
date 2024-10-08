package com.wp.library.Book.domain.book;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PRINTED")
@NoArgsConstructor
public class PrintedBook extends Book {

    private Integer numberOfPages;

    public PrintedBook(String title, String description, Integer rate, String isbn, Integer numberOfPages) {
        super(title, description, rate, isbn);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public PrintedBook clone() {
        return (PrintedBook) super.clone();
    }
}