package exceptions;

public class NonExistanceModelException extends Exception {
    public NonExistanceModelException() {
        super();
    }

    public NonExistanceModelException(String message) {
        super(message);
    }
}
