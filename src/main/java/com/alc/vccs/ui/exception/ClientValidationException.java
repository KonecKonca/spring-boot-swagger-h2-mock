package com.alc.vccs.ui.exception;

public class ClientValidationException extends RuntimeException {
    private static final long serialVersionUID = -8434326652188186052L;

    public ClientValidationException(String message) {
        super(message);
    }

}
