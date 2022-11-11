package de.adesso.adessoseminarmanagement.applicationservice.repository.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminarRepository {
    Seminar save(Seminar seminar);
}
