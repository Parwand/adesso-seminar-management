package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.savePerson(person);
    }

    public Person update(Person person) {
        return personRepository.savePerson(person);
    }

}
