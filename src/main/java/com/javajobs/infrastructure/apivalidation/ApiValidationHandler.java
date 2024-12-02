package com.javajobs.infrastructure.apivalidation;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ApiValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void f() {

    }
}
