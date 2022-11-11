package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarbuchungRepo;
import org.springframework.stereotype.Service;

@Service
public class SeminarbuchungService {

    private final SeminarbuchungRepo seminarbuchungRepo;

    public SeminarbuchungService(SeminarbuchungRepo seminarbuchungRepo) {
        this.seminarbuchungRepo = seminarbuchungRepo;
    }
}
