package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarRepositoryImpl implements SeminarRepository {

    private final SeminarDao seminarDao;

    public SeminarRepositoryImpl(SeminarDao seminarDao) {
        this.seminarDao = seminarDao;
    }
}
