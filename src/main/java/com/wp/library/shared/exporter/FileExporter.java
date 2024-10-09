package com.wp.library.shared.exporter;

import jakarta.annotation.Nullable;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class FileExporter extends DataExporter {

    @Override
    public <T> byte[] export(@Nullable T data) {
        return parseData(data).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    protected <T> String parseData(@Nullable T data) {
        return Objects.toString(data, EMPTY);
    }

    @Override
    public String fileExtension() {
        return "txt";
    }
}
