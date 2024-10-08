package com.wp.library.shared.exporter;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RequiredArgsConstructor
public class ZipExporter extends DataExporter {
    private final DataExporter delegate;

    @SneakyThrows
    @Override
    public <T> byte[] export(@Nullable T data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

            byte[] content = delegate.export(data);
            String fileName = "entry." + delegate.fileExtension();

            ZipEntry zipEntry = new ZipEntry(fileName);
            zipEntry.setSize(content.length);

            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(content);
            zipOutputStream.closeEntry();
            zipOutputStream.finish();

            return outputStream.toByteArray();
        }
    }

    @Override
    protected <T> String parseData(@Nullable T data) {
        return delegate.parseData(data);
    }

    @Override
    public String fileExtension() {
        return "zip";
    }
}
