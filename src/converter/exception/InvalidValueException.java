package converter.exception;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("String must contain only valid roman numerals\n" +
                "[I, V, X, L, C, D, M].");
    }
}
