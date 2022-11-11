package de.adesso.adessoseminarmanagement.applicationservice.repository.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminarraumRepo {
    Seminarraum save(Seminarraum seminarraum);

    Seminarraum getSeminarraumById(Long id);
}
