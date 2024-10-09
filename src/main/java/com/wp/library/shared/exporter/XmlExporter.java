package com.wp.library.shared.exporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@RequiredArgsConstructor
public class XmlExporter extends DataExporter {
    private static final XmlMapper MAPPER = new XmlMapper();

    private final DataExporter delegate;

    @Override
    public <T> byte[] export(@Nullable T data) {
        return delegate.export(parseData(data));
    }

    @Override
    protected <T> String parseData(@Nullable T data) {
        if (isNull(data)) return EMPTY;

        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new ExportException(e);
        }
    }

    @Override
    public String fileExtension() {
        return "xml";
    }
}
