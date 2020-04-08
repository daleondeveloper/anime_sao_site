package ua.daleondeveloper.sao_site.exception;

public class NoAccess extends RuntimeException {

    public NoAccess(String message){
        super(message);
    }

    public NoAccess(String message, Throwable cause){
        super(message,cause);
    }
}
