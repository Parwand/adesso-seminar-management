package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepo;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarraumRepoImpl implements SeminarraumRepo {

    private final SeminarraumDao seminarraumDao;

    public SeminarraumRepoImpl(SeminarraumDao seminarraumDao) {
        this.seminarraumDao = seminarraumDao;
    }
}
