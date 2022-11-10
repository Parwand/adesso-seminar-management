package de.adesso.adessoseminarmanagement.domain.model.seminar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seminarnummer;
    private String seminarTitle;
    private LocalDateTime beginn;
    private LocalDateTime end;
    private String kursinhalt;
    private int Teilnehmeranzahl;
    private String seminarleiter;
    private String voraussetzung;

    public Seminar() {
    }

    public Seminar(String seminarTitle, LocalDateTime beginn, LocalDateTime end, String kursinhalt, int teilnehmeranzahl, String seminarleiter, String voraussetzung) {
        this.seminarTitle = seminarTitle;
        this.beginn = beginn;
        this.end = end;
        this.kursinhalt = kursinhalt;
        Teilnehmeranzahl = teilnehmeranzahl;
        this.seminarleiter = seminarleiter;
        this.voraussetzung = voraussetzung;
    }

    public Long getSeminarnummer() {
        return seminarnummer;
    }

    public void setSeminarnummer(Long seminarnummer) {
        this.seminarnummer = seminarnummer;
    }

    public String getSeminarTitle() {
        return seminarTitle;
    }

    public void setSeminarTitle(String seminarTitle) {
        this.seminarTitle = seminarTitle;
    }

    public LocalDateTime getBeginn() {
        return beginn;
    }

    public void setBeginn(LocalDateTime beginn) {
        this.beginn = beginn;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getKursinhalt() {
        return kursinhalt;
    }

    public void setKursinhalt(String kursinhalt) {
        this.kursinhalt = kursinhalt;
    }

    public int getTeilnehmeranzahl() {
        return Teilnehmeranzahl;
    }

    public void setTeilnehmeranzahl(int teilnehmeranzahl) {
        Teilnehmeranzahl = teilnehmeranzahl;
    }

    public String getSeminarleiter() {
        return seminarleiter;
    }

    public void setSeminarleiter(String seminarleiter) {
        this.seminarleiter = seminarleiter;
    }

    public String getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(String voraussetzung) {
        this.voraussetzung = voraussetzung;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "seminarnummer=" + seminarnummer +
                ", seminarTitle='" + seminarTitle + '\'' +
                ", beginn=" + beginn +
                ", end=" + end +
                ", kursinhalt='" + kursinhalt + '\'' +
                ", Teilnehmeranzahl=" + Teilnehmeranzahl +
                ", seminarleiter='" + seminarleiter + '\'' +
                ", voraussetzung='" + voraussetzung + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seminar seminar = (Seminar) o;

        return Objects.equals(seminarnummer, seminar.seminarnummer);
    }

    @Override
    public int hashCode() {
        return seminarnummer != null ? seminarnummer.hashCode() : 0;
    }
}
