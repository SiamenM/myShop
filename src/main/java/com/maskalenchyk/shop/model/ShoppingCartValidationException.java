package com.maskalenchyk.shop.model;

public class ShoppingCartValidationException extends RuntimeException{

    public ShoppingCartValidationException() {
    }

    public ShoppingCartValidationException(String message) {
        super(message);
    }

    public ShoppingCartValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShoppingCartValidationException(Throwable cause) {
        super(cause);
    }

    public ShoppingCartValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
