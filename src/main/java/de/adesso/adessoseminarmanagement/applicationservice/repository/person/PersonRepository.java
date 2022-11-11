package de.adesso.adessoseminarmanagement.applicationservice.repository.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Person;

public interface PersonRepository {

    public Person savePerson(Person person);
}
