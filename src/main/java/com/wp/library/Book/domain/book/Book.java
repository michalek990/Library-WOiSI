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
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

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
}
