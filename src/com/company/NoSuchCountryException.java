package com.company;

public class NoSuchCountryException extends Exception {
    public NoSuchCountryException(final String message) {
        super(message);
    }
}
