package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Seminarbuchung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buchungsnummer;
    private LocalDate buchungsdatum;

    public Seminarbuchung() {
    }

    public Seminarbuchung(LocalDate buchungsdatum) {
        this.buchungsdatum = buchungsdatum;
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
