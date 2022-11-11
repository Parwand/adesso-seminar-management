package de.adesso.adessoseminarmanagement.infrastructure.util;

import java.util.function.Supplier;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message) {
        super(message);
    }
}
