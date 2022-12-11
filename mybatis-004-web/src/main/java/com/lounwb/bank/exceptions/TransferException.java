package com.lounwb.bank.exceptions;

public class TransferException extends Exception{
    public TransferException() {
        super();
    }

    public TransferException(String message) {
        super(message);
    }
}
