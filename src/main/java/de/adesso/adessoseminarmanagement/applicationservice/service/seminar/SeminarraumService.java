package de.adesso.adessoseminarmanagement.applicationservice.service.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepo;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminarraumService {

    private final SeminarraumRepo seminarraumRepo;

    public SeminarraumService(SeminarraumRepo seminarraumRepo) {
        this.seminarraumRepo = seminarraumRepo;
    }

    public Seminarraum saveSeminarraum(Seminarraum seminarraum) {
        return seminarraumRepo.save(seminarraum);
    }

    public Seminarraum getSeminarraumById(Long id) {
        return seminarraumRepo.getSeminarraumById(id);
    }

    public Seminarraum updateSeminarraum(Seminarraum seminarraum) {
        return seminarraumRepo.save(seminarraum);
    }

    public void deleteSeminarraum(Long id) {
        seminarraumRepo.deleteById(id);
    }

    public List<Seminarraum> getAllSeminarraums() {
        return seminarraumRepo.findAll();
    }
}
