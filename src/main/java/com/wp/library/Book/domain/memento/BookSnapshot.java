package com.wp.library.Book.domain.memento;

import com.wp.library.Book.domain.book.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false, unique = true)
    private Book book;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    public BookSnapshot(Book book) {
        this.book = book;
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.rate = book.getRate();
        this.isbn = getIsbn();
    }

    public BookMemento getMemento() {
        return new BookMemento(this.title, this.description, this.rate, this.isbn);
    }
}
