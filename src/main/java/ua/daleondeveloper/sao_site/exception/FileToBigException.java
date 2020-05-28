package ua.daleondeveloper.sao_site.exception;

public class FileToBigException extends Exception {
    public FileToBigException(String message) {
        super(message);
    }

    public FileToBigException(String message, Throwable cause) {
        super(message, cause);
    }
}
