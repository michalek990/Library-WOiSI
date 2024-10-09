package com.wp.library.shared.exporter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExporterFactory {

    public DataExporter of(ExporterType type, DataExporter delegate) {
        return switch (type) {
            case JSON -> new JsonExporter(delegate);
            case XML -> new XmlExporter(delegate);
            case ZIP -> new ZipExporter(delegate);
        };
    }
}
