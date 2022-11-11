package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarraumDao extends JpaRepository<Seminarraum, Long> {
}
