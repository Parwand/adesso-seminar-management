package de.adesso.adessoseminarmanagement.domain.model.seminar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seminarnummer;
    private String seminarTitle;
    private LocalDateTime beginn;
    private LocalDateTime ende;
    private String kursinhalt;
    private int Teilnehmeranzahl;
    @Column(name = "seminarleiter")
    private Long seminarleiter;
    private String voraussetzung;
    @ManyToOne
    @JoinColumn(name = "seminarraum", referencedColumnName = "raumnummer")
    @JsonProperty("seminarraum")
    private Seminarraum seminarraum;
    // Ein Seminar hat eine Liste von Buchungen
    @OneToMany(mappedBy = "seminar", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    private final List<Seminarbuchung> buchungen = new ArrayList<>();

    public Seminar() {
    }

    public Seminar(String seminarTitle, LocalDateTime beginn, LocalDateTime ende, String kursinhalt, int teilnehmeranzahl, Long seminarleiter, String voraussetzung, Seminarraum seminarraum) {
        this.seminarTitle = seminarTitle;
        this.beginn = beginn;
        this.ende = ende;
        this.kursinhalt = kursinhalt;
        Teilnehmeranzahl = teilnehmeranzahl;
        this.seminarleiter = seminarleiter;
        this.voraussetzung = voraussetzung;
        this.seminarraum = seminarraum;
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

    public LocalDateTime getEnde() {
        return ende;
    }

    public void setEnde(LocalDateTime end) {
        this.ende = end;
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

    public Long getSeminarleiter() {
        return seminarleiter;
    }

    public void setSeminarleiter(Long seminarleiter) {
        this.seminarleiter = seminarleiter;
    }

    public String getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(String voraussetzung) {
        this.voraussetzung = voraussetzung;
    }

    public Seminarraum getSeminarraum() {
        return seminarraum;
    }

    public void setSeminarraum(Seminarraum seminarraum) {
        this.seminarraum = seminarraum;
    }

    public List<Seminarbuchung> getBuchungen() {
        return buchungen;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "seminarnummer=" + seminarnummer +
                ", seminarTitle='" + seminarTitle + '\'' +
                ", beginn=" + beginn +
                ", ende=" + ende +
                ", kursinhalt='" + kursinhalt + '\'' +
                ", Teilnehmeranzahl=" + Teilnehmeranzahl +
                ", seminarleiter='" + seminarleiter + '\'' +
                ", voraussetzung='" + voraussetzung + '\'' +
                ", seminarraum=" + seminarraum +
                ", buchungen=" + buchungen +
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
