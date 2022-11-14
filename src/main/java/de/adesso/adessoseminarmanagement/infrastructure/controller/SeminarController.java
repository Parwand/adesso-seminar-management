package de.adesso.adessoseminarmanagement.infrastructure.controller;

import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarService;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seminar")
public class SeminarController {

    private final SeminarService seminarService;

    public SeminarController(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Seminar>> getAllSeminar() {
        List<Seminar> allSeminar = seminarService.getAllSeminar();
        return new ResponseEntity<>(allSeminar, HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Seminar> getSeminar(@PathVariable String id) {
        Seminar savedSeminar = seminarService.getSeminarById(Long.parseLong(id));
        return new ResponseEntity<>(savedSeminar, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Seminar> addSeminar(@RequestBody Seminar seminar) {
        Seminar savedSeminar = seminarService.saveSeminar(seminar);
        return new ResponseEntity<>(savedSeminar, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Seminar> updateSeminar(@RequestBody Seminar seminar) {
        Seminar savedSeminar = seminarService.updateSeminar(seminar);
        return new ResponseEntity<>(savedSeminar, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeminar(@PathVariable("id") String seminarnummer) {
        seminarService.deleteSeminarById(Long.parseLong(seminarnummer));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
