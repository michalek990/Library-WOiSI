package com.wp.library.Library.infrastructure;

import com.wp.library.Library.domain.Book;
import com.wp.library.Library.domain.adapter.BookAdapter;
import com.wp.library.Library.domain.contract.BookRequest;
import com.wp.library.Library.domain.contract.BookResponse;
import com.wp.library.Library.infrastructure.jpa.BookJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BookService implements BookAdapter {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public BookResponse createBook(BookRequest request) {
        log.info("Użycie wzorca projektowego builder");
        Book book = Book.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .rate(Math.toIntExact(request.getRate()))
                .isbn(request.getIsbn())
                .build();

        bookJpaRepository.save(book);
        return BookResponse.success();
    }
}
