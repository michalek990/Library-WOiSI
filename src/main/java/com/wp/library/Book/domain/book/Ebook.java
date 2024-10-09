package com.wp.library.Book.domain.book;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("EBOOK")
@NoArgsConstructor
public class Ebook extends Book implements Cloneable{

    private String fileFormat;

    public Ebook(String title, String description, Integer rate, String isbn, String fileFormat) {
        super(title, description, rate, isbn);
        this.fileFormat = fileFormat;
    }

    @Override
    public Ebook clone() {
        return (Ebook) super.clone();
    }
}