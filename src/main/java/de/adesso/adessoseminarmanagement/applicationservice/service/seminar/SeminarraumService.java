package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepo;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Service;

@Service
public class SeminarraumService {

    private final SeminarraumRepo seminarraumRepo;

    public SeminarraumService(SeminarraumRepo seminarraumRepo) {
        this.seminarraumRepo = seminarraumRepo;
    }

    public Seminarraum saveSeminarraum(Seminarraum seminarraum) {
        return seminarraumRepo.save(seminarraum);
    }
}
