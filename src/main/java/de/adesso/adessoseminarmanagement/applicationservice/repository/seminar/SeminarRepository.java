package de.adesso.adessoseminarmanagement.applicationservice.repository.seminar;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeminarRepository {
    Seminar save(Seminar seminar);

    Seminar getSeminarById(Long id);

    void deleteById(Long id);

    List<Seminar> findAll();
}
