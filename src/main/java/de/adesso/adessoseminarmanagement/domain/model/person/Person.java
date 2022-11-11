package de.adesso.adessoseminarmanagement.domain.model.person;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String vorname;
    @Column(nullable = false)
    private String nachname;
    @Column(nullable = false)
    private LocalDate geburtsdatum;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Adresse adresse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private List<Seminar> seminarList;
    @ManyToMany
    @JoinTable(name = "person_buchung_map",
            joinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "buchungsnummer", referencedColumnName = "buchungsnummer"))
    private List<Seminarbuchung> seminarbuchungen;

    public Person() {
    }

    public Person(String vorname, String nachname, LocalDate geburtsdatum, Adresse adresse, List<Seminar> seminarList) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.adresse = adresse;
        this.seminarList = seminarList;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Seminar> getSeminarList() {
        return seminarList;
    }

    public void setSeminarList(List<Seminar> seminarList) {
        this.seminarList = seminarList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
