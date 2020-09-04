package exceptions;


public class IssueDateException extends RuntimeException {

    public IssueDateException(String message) {
        super(message);
    }

    public IssueDateException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
