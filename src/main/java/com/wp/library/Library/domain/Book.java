package com.wp.library.Library.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "isbn")
})
@Data
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
    private int rate;

    @Column(name = "isbn", nullable = false)
    private Long isbn;
}
