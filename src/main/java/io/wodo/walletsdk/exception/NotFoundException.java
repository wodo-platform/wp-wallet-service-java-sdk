package io.wodo.walletsdk.exception;

public class NotFoundException extends RuntimeException {

    private static final String ERROR_MSG = "There is no item with given id";

    public NotFoundException() {
        super(ERROR_MSG);
    }
}