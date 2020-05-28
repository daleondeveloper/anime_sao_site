package ua.daleondeveloper.sao_site.exception;

public class BadFileTypeException extends Exception {
    public BadFileTypeException(String message) {
        super(message);
    }

    public BadFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
