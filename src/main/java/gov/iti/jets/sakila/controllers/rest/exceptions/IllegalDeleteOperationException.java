package gov.iti.jets.sakila.controllers.rest.exceptions;

public class IllegalDeleteOperationException extends RuntimeException{
    public IllegalDeleteOperationException(String message) {
        super(message);
    }
}
