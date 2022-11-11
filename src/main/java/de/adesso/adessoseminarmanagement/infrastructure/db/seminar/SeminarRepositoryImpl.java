package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarRepository;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.infrastructure.exception.SeminarNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarRepositoryImpl implements SeminarRepository {

    private final SeminarDao seminarDao;

    public SeminarRepositoryImpl(SeminarDao seminarDao) {
        this.seminarDao = seminarDao;
    }

    @Override
    public Seminar save(Seminar seminar) {
        return seminarDao.save(seminar);
    }

    @Override
    public Seminar getSeminarById(Long id) {
        return seminarDao.findById(id).orElseThrow(() -> new SeminarNotFoundException("Seminar could not be found"));
    }
}
