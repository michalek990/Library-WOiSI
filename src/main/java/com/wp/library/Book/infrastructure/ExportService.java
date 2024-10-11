package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.ExportAdapter;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Book.infrastructure.jpa.BookJpaRepository;
import com.wp.library.shared.exporter.DataExporter;
import com.wp.library.shared.exporter.ExporterFactory;
import com.wp.library.shared.exporter.ExporterType;
import com.wp.library.shared.exporter.FileExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        byte[] content = exporter.export(bookJpaRepository.findAll());
        String fileName = String.join(".", "books", exporter.fileExtension());

        return ExportBookResponse.builder()
                .content(content)
                .fileName(fileName)
                .build();
    }
}
