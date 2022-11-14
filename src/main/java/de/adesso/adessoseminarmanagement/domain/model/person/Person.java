package de.adesso.adessoseminarmanagement.domain.model.person;

import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @ManyToMany
    @JoinTable(
            name = "person_seminar_map",
            joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "seminarnummer", referencedColumnName = "seminarnummer")}
    )
    private List<Seminar> seminarList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_buchung_map",
            joinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "buchungsnummer", referencedColumnName = "buchungsnummer"))
    private List<Seminarbuchung> seminarbuchungen = new ArrayList<>();

    public Person() {
    }

    public Person(String vorname, String nachname, LocalDate geburtsdatum, Adresse adresse, List<Seminar> seminarList, List<Seminarbuchung> seminarbuchungen) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.adresse = adresse;
        this.seminarList = seminarList;
        this.seminarbuchungen = seminarbuchungen;
    }

    public UUID seminarBuchen(Seminar seminar) {
        LocalDate buchungsdatum = LocalDate.now();
        UUID buchungsnummer = UUID.randomUUID();
        Seminarbuchung buchung = new Seminarbuchung(buchungsnummer, buchungsdatum, seminar);
        seminarbuchungen.add(buchung);
        return buchung.getBuchungsnummer();
    }

    public boolean buchungStornieren(UUID buchungsnummer) {
        List<Seminarbuchung> collect = seminarbuchungen.stream().filter((b) -> b.getBuchungsnummer().equals(buchungsnummer)).toList();
        Seminarbuchung seminarbuchung = collect.get(0);
        seminarbuchungen.remove(seminarbuchung);
        return true;
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

    public List<Seminarbuchung> getSeminarbuchungen() {
        return seminarbuchungen;
    }

    public void setSeminarbuchungen(List<Seminarbuchung> seminarbuchungen) {
        this.seminarbuchungen = seminarbuchungen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
