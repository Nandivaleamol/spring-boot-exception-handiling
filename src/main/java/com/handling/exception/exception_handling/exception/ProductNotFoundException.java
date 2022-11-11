package com.handling.exception.exception_handling.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
