package com.wp.library.Book.domain.memento;


import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.exception.BookErrorCode;
import com.wp.library.Book.domain.exception.BookException;
import com.wp.library.Book.infrastructure.jpa.BookSnapshotJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookEditor {

    private final BookSnapshotJpaRepository bookSnapshotJpaRepository;

    public void saveSnapshot(BookOriginator bookOriginator) {
        Book book = bookOriginator.getBook();
        BookSnapshot bookSnapshot = bookSnapshotJpaRepository.findByBook(book).orElse(
               new BookSnapshot(book));
        if (bookSnapshot.getId() != null) {
            BookMemento memento = bookOriginator.createMemento();
            bookSnapshot.setTitle(memento.getTitle());
            bookSnapshot.setDescription(memento.getDescription());
            bookSnapshot.setRate(memento.getRate());
            bookSnapshot.setIsbn(memento.getIsbn());
        }
        bookSnapshotJpaRepository.save(bookSnapshot);
    }

    public void restore(BookOriginator bookOriginator) {
        Book book = bookOriginator.getBook();
        BookSnapshot bookSnapshot = bookSnapshotJpaRepository.findByBook(book)
                .orElseThrow(()->new BookException(BookErrorCode.BOOK_SNAPSHOT_NOT_FOUND));
        bookOriginator.restoreFromMemento(bookSnapshot.getMemento());
    }
}
