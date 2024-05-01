package az.kapitalbank.secrets.exception;

public class NotExistsException extends RuntimeException {
    public NotExistsException(String message) {
        super(message);
    }
}