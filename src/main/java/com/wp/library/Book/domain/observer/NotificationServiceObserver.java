package com.wp.library.Book.domain.observer;

import com.wp.library.Book.domain.book.Book;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Notification.infrastructure.ClonedBookNotificationService;
import com.wp.library.Notification.infrastructure.CreatedBookNotificationService;
import com.wp.library.Notification.infrastructure.ExportedBookNotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
@RequiredArgsConstructor
public class NotificationServiceObserver implements Observer {

    private final CreatedBookNotificationService createdBookNotificationService;
    private final ClonedBookNotificationService clonedBookNotificationService;
    private final ExportedBookNotificationService exportedBookNotificationService;

    @Override
    public void update(Event event) {
        switch (event.getEventType()) {
            case BOOK_CREATED -> {
                BookRequest bookRequest = (BookRequest) event.getData();
                createdBookNotificationService.sendNotification(bookRequest.getTitle(), bookRequest.getDescription(), bookRequest.getToMail());
            }
            case BOOK_CLONED -> {
                BookRequest request = (BookRequest) event.getData();
                clonedBookNotificationService.sendNotification(request.getTitle(), request.getDescription(), request.getToMail());
            }
            case BOOK_EXPORTED -> {
                ExportBookRequest exportBookRequest = (ExportBookRequest) event.getData();
                exportedBookNotificationService.sendNotification(EMPTY, EMPTY, exportBookRequest.getToMail());
            }
        }
    }
}
