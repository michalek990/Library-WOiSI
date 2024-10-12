package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.BookAdapter;
import com.wp.library.Book.domain.constants.BookType;
import com.wp.library.Book.domain.adapter.LibraryAdapter;
import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.BookResponse;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Book.domain.contract.ExportBookResponse;
import com.wp.library.Notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LibraryService implements LibraryAdapter {

    private final BookAdapter bookAdapter;
    private final ExportService exportService;
    private final NotificationService notificationService;


    @Override
    public BookResponse createBook(BookRequest bookRequest, BookType bookType) {
        BookResponse response = switch (bookType) {
            case EBOOK -> bookAdapter.createEbook(bookRequest);
            case PRINTED_BOOK -> bookAdapter.createPrintedBook(bookRequest);
            default -> bookAdapter.createBook(bookRequest);
        };
        notificationService.sendCreatedBookEmailNotification(bookRequest);
        return response;
    }

    @Override
    public BookResponse cloneBook(BookRequest request, Long existingBookId,BookType bookType) {
        BookResponse response = switch (bookType) {
            case EBOOK -> bookAdapter.createCloneEbook(request, existingBookId);
            case PRINTED_BOOK -> bookAdapter.createClonePrintedBook(request, existingBookId);
            default -> throw new UnsupportedOperationException("Unsupported book type for cloning!" + bookType);
        };
        notificationService.sendCloningBookNotification(request);
        return response;
    }

    @Override
    public ExportBookResponse exportBook(ExportBookRequest request){
        notificationService.sendExportBookNotification(request);
        return exportService.exportBook(request);
    }

}
