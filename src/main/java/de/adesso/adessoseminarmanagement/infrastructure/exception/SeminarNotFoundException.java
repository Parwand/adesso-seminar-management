package de.adesso.adessoseminarmanagement.infrastructure.exception;

public class SeminarNotFoundException extends RuntimeException {
    public SeminarNotFoundException(String message) {
        super(message);
    }
}
