package com.amazon.ata.music.playlist.service.exceptions;

public class InvalidAttributeException extends RuntimeException{
    private static final long serialVersionUID = 4204559482778755660L;

    public InvalidAttributeException() {
        super();
    }

    public InvalidAttributeException(String message) {
        super(message);
    }

    public InvalidAttributeException(Throwable cause) {
        super(cause);
    }

    public InvalidAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
