package com.wp.library.Library.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum BookErrorCode {

    BOOK_NOT_FOUND("Book not found by id: %s", NOT_FOUND);

    private final String message;
    private final HttpStatus status;
}
