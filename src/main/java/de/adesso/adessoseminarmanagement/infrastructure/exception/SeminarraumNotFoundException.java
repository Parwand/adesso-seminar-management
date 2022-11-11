package de.adesso.adessoseminarmanagement.infrastructure.exception;

public class SeminarraumNotFoundException extends RuntimeException {
    public SeminarraumNotFoundException(String message) {
        super(message);
    }
}
