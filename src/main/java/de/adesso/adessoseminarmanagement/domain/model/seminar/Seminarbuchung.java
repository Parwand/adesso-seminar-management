package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Seminarbuchung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buchungsnummer;
    private LocalDate buchungsdatum;
    @ManyToOne(targetEntity = Seminar.class)
    @JoinColumn(name = "seminarnummer", referencedColumnName = "seminarnummer")
    private int seminar;

    public Seminarbuchung() {
    }

    public Seminarbuchung(LocalDate buchungsdatum, int seminar) {
        this.buchungsdatum = buchungsdatum;
        this.seminar = seminar;
    }

    public Long getBuchungsnummer() {
        return buchungsnummer;
    }

    public void setBuchungsnummer(Long buchungsnummer) {
        this.buchungsnummer = buchungsnummer;
    }

    public LocalDate getBuchungsdatum() {
        return buchungsdatum;
    }

    public void setBuchungsdatum(LocalDate buchungsdatum) {
        this.buchungsdatum = buchungsdatum;
    }

    public int getSeminar() {
        return seminar;
    }

    public void setSeminar(int seminar) {
        this.seminar = seminar;
    }

    @Override
    public String toString() {
        return "Seminarbuchung{" +
                "buchungsnummer=" + buchungsnummer +
                ", buchungsdatum=" + buchungsdatum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seminarbuchung that = (Seminarbuchung) o;

        return Objects.equals(buchungsnummer, that.buchungsnummer);
    }

    @Override
    public int hashCode() {
        return buchungsnummer != null ? buchungsnummer.hashCode() : 0;
    }
}
