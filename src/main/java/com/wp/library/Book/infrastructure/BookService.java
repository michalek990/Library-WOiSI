package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.BookAdapter;
import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.book.Ebook;
import com.wp.library.Book.domain.book.PrintedBook;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Book.infrastructure.jpa.BookJpaRepository;
import com.wp.library.shared.exporter.DataExporter;
import com.wp.library.shared.exporter.ExporterFactory;
import com.wp.library.shared.exporter.ExporterType;
import com.wp.library.shared.exporter.FileExporter;
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
                .rate(request.getRate())
                .isbn(request.getIsbn())
                .build();

        bookJpaRepository.save(book);
        return BookResponse.success();
    }

    public BookResponse createEbook(BookRequest request) {
        log.info("Użycie wzorca projektowego factory");
        Ebook ebook = BookFactory.createEbook(
                request.getTitle(),
                request.getDescription(),
                request.getRate(),
                request.getIsbn(),
                request.getAdditionalAttribute()
        );

        bookJpaRepository.save(ebook);
        return BookResponse.success();
    }

    public BookResponse createPrintedBook(BookRequest request) {
        log.info("Użycie wzorca projektowego factory");
        PrintedBook printedBook = BookFactory.createPrintedBook(
                request.getTitle(),
                request.getDescription(),
                request.getRate(),
                request.getIsbn(),
                Integer.parseInt(request.getAdditionalAttribute())
        );

        bookJpaRepository.save(printedBook);
        return BookResponse.success();
    }

    @Override
    public ExportBookResponse exportBook(ExportBookRequest request) {
        DataExporter exporter = new FileExporter();

        for (ExporterType type: request.getFormats()) {
            exporter = ExporterFactory.of(type, exporter);
        }

        byte[] content = exporter.export(bookJpaRepository.findAll());
        String fileName = String.join(".", "books", exporter.fileExtension());

        return ExportBookResponse.builder()
                .content(content)
                .fileName(fileName)
                .build();
    }
}
