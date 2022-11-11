package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarRepository;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    private SeminarRepository seminarRepository;

    public SeminarService(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }

    public Seminar saveSeminar(Seminar seminar) {
        return seminarRepository.save(seminar);
    }
}
