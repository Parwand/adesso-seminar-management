package de.adesso.adessoseminarmanagement.infrastructure.db.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;

public class PersonRepositoryImpl implements PersonRepository {
    private final PersonDao personDao;

    public PersonRepositoryImpl(PersonDao personDao) {
        this.personDao = personDao;
    }
}
