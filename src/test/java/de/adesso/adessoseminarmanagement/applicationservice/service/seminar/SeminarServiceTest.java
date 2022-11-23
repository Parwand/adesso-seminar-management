package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SeminarServiceTest {
    @Autowired
    private SeminarService seminarService;
    @Autowired
    private SeminarraumService seminarraumService;
    Seminarraum seminarraum  = new Seminarraum("name2", 22L, "big monitor and webCam");

    @BeforeEach
    void setup() {
        seminarraumService.saveSeminarraum(seminarraum);
    }

    @Test
    @DisplayName("seminar can be saved in DB")
    void test_1() {
        // Arrange
        Seminar seminar = new Seminar();
        seminar.setTeilnehmeranzahl(22);
        seminar.setSeminarTitle("Bias and discrimination in Machine Learning");
        seminar.setBeginn(LocalDateTime.now());
        seminar.setEnde(LocalDateTime.of(LocalDate.of(2022, 12, 22), LocalTime.of(9, 30)));
        seminar.setKursinhalt("About datasets, that have bias against the many of groups of people ");
        seminar.setVoraussetzung("Informatik semester 4");
        seminar.setSeminarleiter(1L);
        seminar.setSeminarraum(seminarraum);
        // Act
        seminarraumService.saveSeminarraum(seminarraum);
        seminarService.saveSeminar(seminar);
        Seminar seminarById = seminarService.getSeminarById(seminar.getSeminarnummer());
        // Assert
        assertThat(seminarById).isEqualTo(seminar);
    }
}