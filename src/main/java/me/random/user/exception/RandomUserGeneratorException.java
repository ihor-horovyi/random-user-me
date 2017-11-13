package me.random.user.exception;

public class RandomUserGeneratorException extends RuntimeException {

    public RandomUserGeneratorException() {
        super();
    }

    public RandomUserGeneratorException(String message) {
        super(message);
    }

    public RandomUserGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public RandomUserGeneratorException(Throwable cause) {
        super(cause);
    }

    protected RandomUserGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
