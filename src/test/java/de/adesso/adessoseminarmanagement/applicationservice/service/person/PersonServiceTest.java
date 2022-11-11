package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Adresse;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

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
        person.setVorname("vorname1");
        person.setNachname("nachname1");
        person.setGeburtsdatum(LocalDate.of(1994, 3, 12));
        Adresse adresse = new Adresse("Du", "Eller", "22a", "4055");
        Seminarraum seminarraum1 = new Seminarraum(10L, "All");
        Seminar seminar1 = new Seminar("seminarTitle1",
                LocalDateTime.of(LocalDate.of(2022, 11, 11), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 11, 11), LocalTime.of(12, 0)), "kursinhalt", 10, "seminarleiter1",  "voraussetzung1", seminarraum1);
        person.setAdresse(adresse);
        person.setSeminarList(List.of(seminar1));
        // Act
        personService.save(person);
        // Assert
        assertThat(person.getId()).isNotNull();
    }
}