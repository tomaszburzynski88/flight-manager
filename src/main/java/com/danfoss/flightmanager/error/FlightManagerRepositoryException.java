package com.danfoss.flightmanager.error;

public class FlightManagerRepositoryException extends RuntimeException{
    public FlightManagerRepositoryException() {
    }

    public FlightManagerRepositoryException(String message) {
        super(message);
    }

    public FlightManagerRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightManagerRepositoryException(Throwable cause) {
        super(cause);
    }
}
