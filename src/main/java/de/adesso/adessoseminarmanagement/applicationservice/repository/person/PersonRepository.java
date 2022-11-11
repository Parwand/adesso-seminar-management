package de.adesso.adessoseminarmanagement.applicationservice.repository.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository {

    public Person savePerson(Person person);

    void deletePerson(Long id);
}
