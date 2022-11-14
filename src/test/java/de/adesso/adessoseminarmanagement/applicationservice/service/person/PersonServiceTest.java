package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarService;
import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarraumService;
import de.adesso.adessoseminarmanagement.domain.model.person.Adresse;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import de.adesso.adessoseminarmanagement.infrastructure.exception.PersonNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private SeminarService seminarService;
    @Autowired
    private SeminarraumService seminarraumService;

    @Test
    @DisplayName("person should be saved in DB")
    void test_1() {
        // Arrange
        Person person = new Person();
        person.setVorname("vorname1");
        person.setNachname("nachname1");
        person.setGeburtsdatum(LocalDate.of(1994, 3, 12));
        Adresse adresse = new Adresse("Du", "Eller", "22a", "4055");
        person.setAdresse(adresse);
        // Act
        personService.save(person);
        // Assert
        assertThat(person.getId()).isNotNull();
    }

    @Test
    @DisplayName("person should be saved in DB with seminarList and seminarraum")
    void test_2() {
        // Arrange
        Person person = new Person();
        person.setVorname("vorname2");
        person.setNachname("nachname2");
        person.setGeburtsdatum(LocalDate.of(1994, 3, 12));
        Adresse adresse = new Adresse("KO", "Uni", "13a", "20344");
        Seminarraum seminarraum1 = new Seminarraum(10L, "All");
        seminarraumService.saveSeminarraum(seminarraum1);
        Seminar seminar1 = new Seminar("seminarTitle1",
                LocalDateTime.of(LocalDate.of(2022, 11, 11), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 11, 11), LocalTime.of(12, 0)), "kursinhalt", 10, "seminarleiter1",  "voraussetzung1", seminarraum1);
        seminarService.saveSeminar(seminar1);
        person.setAdresse(adresse);
        person.setSeminarList(List.of(seminar1));
        // Act
        personService.save(person);
        // Assert
        assertThat(person.getId()).isNotNull();
    }

    @Test
    @DisplayName("person could be updated")
    void test_3() {
        // Arrange
        Person person = new Person();
        person.setVorname("vorname3");
        person.setNachname("nachname3");
        person.setGeburtsdatum(LocalDate.of(1991, 4, 23));
        Adresse adresse = new Adresse("Berlin", "Berliner", "56", "23034");
        person.setAdresse(adresse);
        // Act
        personService.save(person);
        person.setVorname("vorname3_updated");
        person.setNachname("nachname3_updated");
        person.setGeburtsdatum(LocalDate.of(1991, 4, 23));
        adresse.setStrassennummer("56b");
        person.setAdresse(adresse);
        personService.update(person);
        // Assert
        assertThat(person.getVorname()).isEqualTo("vorname3_updated");
        assertThat(person.getNachname()).isEqualTo("nachname3_updated");
        assertThat(person.getGeburtsdatum()).isEqualTo(LocalDate.of(1991, 4, 23));
        assertThat(person.getAdresse().getStrassennummer()).isEqualTo("56b");
    }

    @Test
    @DisplayName("person should be loaded from Database")
    void test_4() {
        // Arrange
        Person person = new Person();
        person.setVorname("vorname4");
        person.setNachname("nachname4");
        person.setGeburtsdatum(LocalDate.of(2000, 4, 8));
        Adresse adresse = new Adresse("Bochum", "street", "45", "33343");
        person.setAdresse(adresse);
        // Act
        personService.save(person);
        Person loaded_person = personService.getPerson(person.getId());
        // Assert
        assertThat(loaded_person).isNotNull();
        assertThat(loaded_person.getId()).isEqualTo(person.getId());
    }

    @Test
    @DisplayName("person could be deleted")
    void test_5() {
        // Arrange
        Person person = new Person();
        person.setVorname("vorname5");
        person.setNachname("nachname5");
        person.setGeburtsdatum(LocalDate.of(2000, 4, 8));
        Adresse adresse = new Adresse("Bochum", "street", "45", "33343");
        person.setAdresse(adresse);
        // Act
        personService.save(person);
        personService.deletePerson(person.getId());
        // Assert
        assertThrows(PersonNotFoundException.class, () -> personService.getPerson(person.getId()));
    }

    @Test
    @DisplayName("get all people in DB")
    void test_6() {
        // Arrange
        // Person 1
        Person person1 = new Person();
        person1.setVorname("vorname-person1");
        person1.setNachname("nachname-person1");
        person1.setGeburtsdatum(LocalDate.of(2000, 4, 8));
        Adresse adresse1 = new Adresse("Bochum", "street", "45", "33343");
        person1.setAdresse(adresse1);
        // Person 2
        Person person2 = new Person();
        person2.setVorname("vorname-person2");
        person2.setNachname("nachname-person2");
        person2.setGeburtsdatum(LocalDate.of(1993, 7, 2));
        Adresse adresse2 = new Adresse("Bochum", "street", "45", "33343");
        person2.setAdresse(adresse2);
        // Act
        personService.save(person1);
        personService.save(person2);
        List<Person> people = personService.personList();
        // Assert
    }

    @Test
    @DisplayName("person should be saved in DB with booking of seminar")
    void test_7() {
        // Arrange
        Seminar seminar = new Seminar();
        seminar.setTeilnehmeranzahl(10);
        Person person = new Person();
        person.setVorname("vorname7");
        person.setNachname("nachname7");
        person.setGeburtsdatum(LocalDate.of(1995, 8, 20));
        Adresse adresse = new Adresse("Hamburg", "Lion", "30a", "33229");
        person.setAdresse(adresse);
        person.seminarBuchen(seminar);
        // Act
        seminarService.saveSeminar(seminar);
        personService.save(person);
        // Assert
        assertThat(person.getSeminarbuchungen()).isNotNull();
    }
}