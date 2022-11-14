package de.adesso.adessoseminarmanagement.applicationservice.repository.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeminarraumRepo {
    Seminarraum save(Seminarraum seminarraum);

    Seminarraum getSeminarraumById(Long id);

    void deleteById(Long id);

    List<Seminarraum> findAll();
}
