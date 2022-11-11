package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarDao extends JpaRepository<Seminar, Long> {
}
