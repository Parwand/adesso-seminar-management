package de.adesso.adessoseminarmanagement.infrastructure.controller;

import de.adesso.adessoseminarmanagement.applicationservice.service.seminar.SeminarService;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
