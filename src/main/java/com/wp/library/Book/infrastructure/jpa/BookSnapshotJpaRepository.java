package com.wp.library.Book.infrastructure.jpa;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.memento.BookSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookSnapshotJpaRepository extends JpaRepository<BookSnapshot,Long> {

    Optional<BookSnapshot> findByBook(Book book);
}
