package javakrk9.exceptions;

public class AuthorNotFoundException extends Exception {

    private String errorCode;
    public AuthorNotFoundException(String message, String errorCode) {
        super(message);

    }
}
