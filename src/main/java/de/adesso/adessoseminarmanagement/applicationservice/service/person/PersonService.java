package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public void deletePerson(Long id) {
        personRepository.deletePerson(id);
    }

    public Person getPerson(Long id) {
        return personRepository.getPerson(id);
    }

    public List<Person> personList() {
        return personRepository.getAllPersons();
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Boolean buchungStornieren(UUID buchungsnummer, Long personId) {
        Person person = personRepository.getPerson(personId);
        boolean result = person.buchungStornieren(buchungsnummer);
        if (result) {
            personRepository.savePerson(person);
            return true;
        } else {
            return false;
        }
    }

}
