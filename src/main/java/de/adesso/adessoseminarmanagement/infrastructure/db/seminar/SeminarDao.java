package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeminarDao extends JpaRepository<Seminar, Long> {
    List<Seminar> findAllByOrderBySeminarnummerAsc();
}
