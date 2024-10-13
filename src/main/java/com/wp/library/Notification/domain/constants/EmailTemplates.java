package com.wp.library.Notification.domain.constants;

public final class EmailTemplates {

    public static final String CREATE_BOOK_SUBJECT = "New Book Created: %s";
    public static final String CLONE_BOOK_SUBJECT = "Book Cloned: %s";
    public static final String EXPORT_BOOKS_SUBJECT = "Your Book Export is Ready";

    public static final String CREATE_BOOK_BODY = """
            Hello,

            The book '%s' has been successfully created with the following details:

            Thank you for using our library system!""";

    public static final String CLONE_BOOK_BODY = """
            Hello,

            The book '%s' has been successfully cloned. Here are the details:

            Enjoy your new book!""";

    public static final String EXPORT_BOOKS_BODY = """
            Hello,

            Your requested book export is ready. Please check the attached file for details.

            Thank you for using our library system!""";
}
