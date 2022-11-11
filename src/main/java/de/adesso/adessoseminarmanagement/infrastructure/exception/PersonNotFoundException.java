package de.adesso.adessoseminarmanagement.infrastructure.exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message) {
        super(message);
    }
}
