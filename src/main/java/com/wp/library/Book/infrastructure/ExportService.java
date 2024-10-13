package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.ExportAdapter;
import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Book.infrastructure.jpa.BookJpaRepository;
import com.wp.library.Book.infrastructure.strategy.BookSortingStrategy;
import com.wp.library.Book.infrastructure.strategy.BookSortingStrategyFactory;
import com.wp.library.shared.exporter.DataExporter;
import com.wp.library.shared.exporter.ExporterFactory;
import com.wp.library.shared.exporter.ExporterType;
import com.wp.library.shared.exporter.FileExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportService implements ExportAdapter {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public ExportBookResponse exportBook(ExportBookRequest request) {
        DataExporter exporter = new FileExporter();

        for (ExporterType type: request.getFormats()) {
            exporter = ExporterFactory.of(type, exporter);
        }

        List<Book> books = bookJpaRepository.findAll();
        for (ExportBookRequest.SortType sort : request.getSorts()) {
            BookSortingStrategy strategy = BookSortingStrategyFactory.getStrategy(sort.sortType());
            books = strategy.sort(books, sort.direction());
        }

        byte[] content = exporter.export(bookJpaRepository.findAll());
        String fileName = String.join(".", "books", exporter.fileExtension());

        return ExportBookResponse.builder()
                .content(content)
                .fileName(fileName)
                .build();
    }
}
