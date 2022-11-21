package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;
import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarService;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final SeminarService seminarService;

    public PersonService(PersonRepository personRepository, SeminarService seminarService) {
        this.personRepository = personRepository;
        this.seminarService = seminarService;
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

    public Person getPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
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

    public Boolean seminarBuchen(Long seminarnummer, Long personId) {
        Person person = personRepository.getPerson(personId);
        Seminar seminar = seminarService.getSeminarById(seminarnummer);
        Boolean istGebucht = person.seminarBuchen(seminar);
        personRepository.savePerson(person);
        return istGebucht;
    }

}
