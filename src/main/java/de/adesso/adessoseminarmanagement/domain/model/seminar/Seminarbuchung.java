package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Seminarbuchung {
    @Id
    private UUID buchungsnummer;
    private LocalDate buchungsdatum;
    @ManyToOne()
    @JoinColumn(name = "seminarnummer", referencedColumnName = "seminarnummer")
    private Seminar seminar;

    public Seminarbuchung() {
    }

    public Seminarbuchung(UUID buchungsnummer, LocalDate buchungsdatum, Seminar seminar) {
        this.buchungsnummer = buchungsnummer;
        this.buchungsdatum = buchungsdatum;
        this.seminar = seminar;
    }

    public UUID getBuchungsnummer() {
        return buchungsnummer;
    }

    public void setBuchungsnummer(UUID buchungsnummer) {
        this.buchungsnummer = buchungsnummer;
    }

    public LocalDate getBuchungsdatum() {
        return buchungsdatum;
    }

    public void setBuchungsdatum(LocalDate buchungsdatum) {
        this.buchungsdatum = buchungsdatum;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
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
