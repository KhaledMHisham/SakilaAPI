package gov.iti.jets.sakila.controllers.rest.exceptions;

public class IllegalSaveOperationException extends RuntimeException{
    public IllegalSaveOperationException(String message) {
        super(message);
    }
}
