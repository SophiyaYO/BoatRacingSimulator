package exceptions;

public class ArgumentException extends Exception {
    private String message;


    public ArgumentException(String message) {
        this.message = message;
    }
}
