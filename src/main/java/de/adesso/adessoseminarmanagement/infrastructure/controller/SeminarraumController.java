package de.adesso.adessoseminarmanagement.infrastructure.controller;

import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarraumService;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seminarraum")
public class SeminarraumController {

    private final SeminarraumService seminarraumService;

    public SeminarraumController(SeminarraumService seminarraumService) {
        this.seminarraumService = seminarraumService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Seminarraum>> getAllSeminarraums() {
        List<Seminarraum> allSeminarraums = seminarraumService.getAllSeminarraums();
        return new ResponseEntity<>(allSeminarraums, HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Seminarraum> getSeminarraum(@PathVariable String id) {
        Seminarraum savedSeminarraum = seminarraumService.getSeminarraumById(Long.parseLong(id));
        return new ResponseEntity<>(savedSeminarraum, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Seminarraum> addSeminarraum(@RequestBody Seminarraum seminarraum) {
        Seminarraum savedSeminarraum = seminarraumService.saveSeminarraum(seminarraum);
        return new ResponseEntity<>(savedSeminarraum, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Seminarraum> updateSeminarraum(@RequestBody Seminarraum seminarraum) {
        Seminarraum savedSeminarraum = seminarraumService.updateSeminarraum(seminarraum);
        return new ResponseEntity<>(savedSeminarraum, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteSeminarraum(@PathVariable("id") String seminarnummer) {
        seminarraumService.deleteSeminarraum(Long.parseLong(seminarnummer));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
