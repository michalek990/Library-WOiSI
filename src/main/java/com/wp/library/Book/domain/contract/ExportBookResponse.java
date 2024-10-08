package com.wp.library.Book.domain.contract;

import lombok.Builder;

@Builder
public record ExportBookResponse(
        byte[] content,
        String fileName
) {}
