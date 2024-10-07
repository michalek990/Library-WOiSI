package com.wp.library.shared.interfaces;

import com.wp.library.shared.exception.ErrorResponse;
import jakarta.validation.ClockProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BaseExceptionHandler {

    private final ClockProvider clockProvider;

    protected ResponseEntity<ErrorResponse> createErrorResponse(Exception exception, HttpStatus status){
        log.error("{} {} {}", exception.getClass().getSimpleName(), exception.getMessage(), exception.getStackTrace(), exception);
        return new ResponseEntity<>(ErrorResponse.from(
                exception.getMessage(),
                status.value(),
                exception.getClass().getName(),
                clockProvider.getClock().instant().toString()),
                status
        );
    }
}
