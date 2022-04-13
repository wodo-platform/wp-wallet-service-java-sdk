package io.wodo.walletsdk.exception;

public class WalletNotFoundException extends RuntimeException {

    private static final String ERROR_MSG = "There is no wallet with given id";

    public WalletNotFoundException() {
        super(ERROR_MSG);
    }
}