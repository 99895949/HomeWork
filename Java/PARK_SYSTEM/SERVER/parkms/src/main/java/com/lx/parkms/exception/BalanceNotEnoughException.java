package com.lx.parkms.exception;

public class BalanceNotEnoughException extends Exception {
    public BalanceNotEnoughException() {
        super();
    }

    public BalanceNotEnoughException(String message) {
        super(message);
    }

    public BalanceNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public BalanceNotEnoughException(Throwable cause) {
        super(cause);
    }

    protected BalanceNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
