package com.wp.library.Notification.adapter;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.ExportBookRequest;

public interface NotificationAdapter {
    void sendCreatedBookEmailNotification(BookRequest request);
    void sendCloningBookNotification(BookRequest request);
    void sendExportBookNotification(ExportBookRequest request);
}
