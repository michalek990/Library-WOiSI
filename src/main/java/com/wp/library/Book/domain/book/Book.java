package com.wp.library.Book.domain.book;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "isbn")
})
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "book_type")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book implements Cloneable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    public Book(String title, String description, Integer rate, String isbn) {
        this.title = title;
        this.description = description;
        this.rate = rate;
        this.isbn = isbn;
    }


    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }


    public static class BookBuilder {

        private Long id;
        private String title;
        private String description;
        private Integer rate;
        private String isbn;

        BookBuilder() {
        }

        public BookBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BookBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public BookBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public BookBuilder rate(final Integer rate) {
            this.rate = rate;
            return this;
        }

        public BookBuilder isbn(final String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book build() {
            return new Book(this.id, this.title, this.description, this.rate, this.isbn);
        }

    }
}
