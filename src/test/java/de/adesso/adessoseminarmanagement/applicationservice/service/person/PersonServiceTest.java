package de.adesso.adessoseminarmanagement.applicationservice.service.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Adresse;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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
}