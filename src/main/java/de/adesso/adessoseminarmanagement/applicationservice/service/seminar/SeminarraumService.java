package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepository;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminarraumService {

    private final SeminarraumRepository seminarraumRepository;

    public SeminarraumService(SeminarraumRepository seminarraumRepository) {
        this.seminarraumRepository = seminarraumRepository;
    }

    public Seminarraum saveSeminarraum(Seminarraum seminarraum) {
        return seminarraumRepository.save(seminarraum);
    }

    public Seminarraum getSeminarraumById(Long id) {
        return seminarraumRepository.getSeminarraumById(id);
    }

    public Seminarraum updateSeminarraum(Seminarraum seminarraum) {
        return seminarraumRepository.save(seminarraum);
    }

    public void deleteSeminarraum(Long id) {
        seminarraumRepository.deleteById(id);
    }

    public List<Seminarraum> getAllSeminarraums() {
        return seminarraumRepository.findAll();
    }
}
