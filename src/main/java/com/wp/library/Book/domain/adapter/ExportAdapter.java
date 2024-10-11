package com.wp.library.Book.domain.adapter;

import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;

public interface ExportAdapter {

    ExportBookResponse exportBook(ExportBookRequest request);
}
