package de.adesso.adessoseminarmanagement.infrastructure.db.seminar;

import de.adesso.adessoseminarmanagement.applicationservice.repository.seminar.SeminarraumRepository;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import de.adesso.adessoseminarmanagement.infrastructure.exception.SeminarraumNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeminarraumRepoImpl implements SeminarraumRepository {

    private final SeminarraumDao seminarraumDao;

    public SeminarraumRepoImpl(SeminarraumDao seminarraumDao) {
        this.seminarraumDao = seminarraumDao;
    }

    @Override
    public Seminarraum save(Seminarraum seminarraum) {
        return seminarraumDao.save(seminarraum);
    }

    @Override
    public Seminarraum getSeminarraumById(Long id) {
        return seminarraumDao.findById(id).orElseThrow(() -> new SeminarraumNotFoundException("SeminarRoom not Found"));
    }

    @Override
    public void deleteById(Long id) {
        seminarraumDao.deleteById(id);
    }

    @Override
    public List<Seminarraum> findAll() {
        return seminarraumDao.findAllByOrderByRaumnummer();
    }
}
