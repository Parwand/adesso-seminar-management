package de.adesso.adessoseminarmanagement.domain.model.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adresse {
    @Id
    private Long id;

    public Adresse() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
