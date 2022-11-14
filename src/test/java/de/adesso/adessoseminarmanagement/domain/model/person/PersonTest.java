package de.adesso.adessoseminarmanagement.domain.model.person;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;
    @BeforeEach
    void setup() {
        person = new Person();
        person.setVorname("vorname");
        person.setNachname("nachname");
        person.setAdresse(new Adresse("stadt", "straße", "22", "33242"));
        person.setGeburtsdatum(LocalDate.of(1995, 3, 28));
    }

    @Test
    @DisplayName("Person can book a seminar")
    void test_1() {
        person.seminarBuchen(22L);
        List<Seminarbuchung> seminarbuchungen = person.getSeminarbuchungen();
        assertThat(seminarbuchungen.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Person can cancel a booking of seminar")
    void test_2() {
        // Act
        person.seminarBuchen(24L);
        List<Seminarbuchung> seminarbuchungen = person.getSeminarbuchungen();
        Seminarbuchung seminarbuchung = seminarbuchungen.get(0);
        UUID buchungsnummer = seminarbuchung.getBuchungsnummer();
        person.buchungStornieren(buchungsnummer);
        List<Seminarbuchung> seminarbuchungenAfterCancel = person.getSeminarbuchungen();
        // Assert
        assertThat(seminarbuchungenAfterCancel.size()).isEqualTo(0);
    }
}