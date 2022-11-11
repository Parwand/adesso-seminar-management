package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarbuchungRepo;
import org.springframework.stereotype.Repository;

@Repository
public class SeminarbuchungRepoImpl implements SeminarbuchungRepo {
    private final SeminarbuchungDao seminarbuchungDao;

    public SeminarbuchungRepoImpl(SeminarbuchungDao seminarbuchungDao) {
        this.seminarbuchungDao = seminarbuchungDao;
    }
}
