package com.wp.library.shared.exporter;

public abstract class DataExporter {
    public abstract <T> byte[] export(T data);
    protected abstract <T> String parseData(T data);
    public abstract String fileExtension();
}
