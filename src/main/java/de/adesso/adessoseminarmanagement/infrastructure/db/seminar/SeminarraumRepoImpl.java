package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepo;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarraumRepoImpl implements SeminarraumRepo {

    private final SeminarraumDao seminarraumDao;

    public SeminarraumRepoImpl(SeminarraumDao seminarraumDao) {
        this.seminarraumDao = seminarraumDao;
    }

    @Override
    public Seminarraum save(Seminarraum seminarraum) {
        return seminarraumDao.save(seminarraum);
    }
}
