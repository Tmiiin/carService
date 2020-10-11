package ru.vtb.hakaton.cars.exception;

public class CarServiceException extends RuntimeException {

    private static final long serialVersionUID = 7776734367104079995L;

    public CarServiceException() {
        super();
    }

    public CarServiceException(String message) {
        super(message);
    }

    public CarServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarServiceException(Throwable cause) {
        super(cause);
    }

    protected CarServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
