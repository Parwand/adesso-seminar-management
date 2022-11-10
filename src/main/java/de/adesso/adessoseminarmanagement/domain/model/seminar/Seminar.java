package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seminar {

    @Id
    private Long id;

    public Seminar() {
    }
}
