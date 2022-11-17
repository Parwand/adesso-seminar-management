package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SeminarraumServiceTest {
    @Autowired
    private SeminarraumService seminarraumService;

    @Test
    @DisplayName("seminar room can be saved in DB")
    void test_1() {
        // Arrange
        Seminarraum seminarraum = new Seminarraum();
        seminarraum.setName("Heinrich Heine");
        seminarraum.setMaximalePersonenanzahl(22L);
        seminarraum.setAusstattung("with all services");
        // Act
        seminarraumService.saveSeminarraum(seminarraum);
        // Assert
        assertThat(seminarraum.getRaumnummer()).isNotNull();
    }

    @Test
    @DisplayName("'seminarraum' which cane be loaded from database")
    void test_2() {
        // Arrange
        Seminarraum seminarraum = new Seminarraum();
        seminarraum.setName("Adesso SE");
        seminarraum.setMaximalePersonenanzahl(22L);
        seminarraum.setAusstattung("with all services");
        // Act
        seminarraumService.saveSeminarraum(seminarraum);
        Seminarraum seminarraumById = seminarraumService.getSeminarraumById(seminarraum.getRaumnummer());
        // Assert
        assertThat(seminarraumById).isEqualTo(seminarraum);
    }
}