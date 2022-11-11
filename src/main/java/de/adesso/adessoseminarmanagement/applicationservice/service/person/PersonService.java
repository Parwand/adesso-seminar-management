package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
