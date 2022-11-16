package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Seminarraum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raumnummer;

    private String name;
    private Long maximalePersonenanzahl;
    private String ausstattung;
    @OneToMany(mappedBy = "seminarraum", cascade = CascadeType.REMOVE)
    private final List<Seminar> seminare = new ArrayList<>();

    public Seminarraum() {
    }

    public Seminarraum(String name, Long maximalePersonenanzahl, String ausstattung) {
        this.name = name;
        this.maximalePersonenanzahl = maximalePersonenanzahl;
        this.ausstattung = ausstattung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRaumnummer() {
        return raumnummer;
    }

    public void setRaumnummer(Long raumnummer) {
        this.raumnummer = raumnummer;
    }

    public Long getMaximalePersonenanzahl() {
        return maximalePersonenanzahl;
    }

    public void setMaximalePersonenanzahl(Long maximalePersonenanzahl) {
        this.maximalePersonenanzahl = maximalePersonenanzahl;
    }

    public String getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    @Override
    public String toString() {
        return "Seminarraum{" +
                "raumnummer=" + raumnummer +
                ", maximalePersonenanzahl=" + maximalePersonenanzahl +
                ", ausstattung='" + ausstattung + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seminarraum that)) return false;

        return Objects.equals(raumnummer, that.raumnummer);
    }

    @Override
    public int hashCode() {
        return raumnummer != null ? raumnummer.hashCode() : 0;
    }
}
