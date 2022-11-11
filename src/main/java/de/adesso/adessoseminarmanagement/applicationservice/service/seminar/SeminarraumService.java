package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepo;
import org.springframework.stereotype.Service;

@Service
public class SeminarraumService {

    private final SeminarraumRepo seminarraumRepo;

    public SeminarraumService(SeminarraumRepo seminarraumRepo) {
        this.seminarraumRepo = seminarraumRepo;
    }
}
