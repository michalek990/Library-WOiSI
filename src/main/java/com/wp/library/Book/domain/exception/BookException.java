package com.wp.library.Book.domain.exception;

import lombok.Getter;

@Getter
public class BookException extends RuntimeException {

    private final BookErrorCode errorCode;

    public BookException(BookErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.errorCode = errorCode;
    }
}
