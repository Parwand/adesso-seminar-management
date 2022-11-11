package de.adesso.adessoseminarmanagement.applicationservice.service;

import de.adesso.adessoseminarmanagement.applicationservice.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
