package de.adesso.adessoseminarmanagement.applicationservice.repository.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

    public Person savePerson(Person person);

    void deletePerson(Long id);

    Person getPerson(Long id);

    List<Person> getAllPersons();

    List<Person> findAll();

    Person findPersonByUsername(String username);
}
