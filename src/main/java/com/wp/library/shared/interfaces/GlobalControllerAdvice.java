package com.wp.library.shared.interfaces;

import jakarta.annotation.Priority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Priority(1)
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    private final BaseExceptionHandler baseExceptionHandler;

    //TODO dodac kolejne inne wyjątki
}