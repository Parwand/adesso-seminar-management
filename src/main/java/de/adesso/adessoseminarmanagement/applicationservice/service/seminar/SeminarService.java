package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarRepository;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    private SeminarRepository seminarRepository;

    public SeminarService(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }
}
