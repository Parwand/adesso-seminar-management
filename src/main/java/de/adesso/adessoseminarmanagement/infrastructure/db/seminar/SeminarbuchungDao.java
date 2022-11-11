package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarbuchungDao extends JpaRepository<Seminarbuchung, Long> {
}
