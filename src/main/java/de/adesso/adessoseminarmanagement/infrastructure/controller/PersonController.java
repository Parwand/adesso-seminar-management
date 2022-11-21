package de.adesso.adessoseminarmanagement.infrastructure.controller;

import de.adesso.adessoseminarmanagement.applicationservice.service.person.PersonService;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> allPersons = personService.getAllPersons();
        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        Person person = personService.getPerson(Long.parseLong(id));
        return new ResponseEntity<>(person, HttpStatus.FOUND);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<Person> getPersonByUsername(@PathVariable String username) {
        Person person = personService.getPersonByUsername(username);
        return new ResponseEntity<>(person, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person savePerson = personService.save(person);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person updatedPerson = personService.update(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.CREATED);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        personService.deletePerson(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buchungen/{personId}")
    public ResponseEntity<List<Seminarbuchung>> getBuchungenByPersonId(@PathVariable String personId) {
        Person person = personService.getPerson(Long.parseLong(personId));
        List<Seminarbuchung> seminarbuchungen = person.getSeminarbuchungen();
        return new ResponseEntity<>(seminarbuchungen, HttpStatus.OK);
    }

    @PostMapping("/buchung/stornieren")
    public ResponseEntity<?> buchungStorniere(@Param("buchungsnummer") String buchungsnummer, @Param("personId") String personId) {
        personService.buchungStornieren(UUID.fromString(buchungsnummer), Long.parseLong(personId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/seminar/buchen")
    public ResponseEntity<Boolean> seminarBuchen(@Param("seminarnummer") String seminarnummer, @Param("personId") String personId) {
        Boolean istGebucht = personService.seminarBuchen(Long.parseLong(seminarnummer), Long.parseLong(personId));
        return new ResponseEntity<>(istGebucht, HttpStatus.OK);
    }
}
