package com.ecommerce.common.exception;

public abstract class ApplicationBaseException extends RuntimeException {
    public ApplicationBaseException(String message) {
        super(message);
    }
}