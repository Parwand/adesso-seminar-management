package de.adesso.adessoseminarmanagement.domain.model.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adresse {
    @Id
    private Long id;
    private String stadt;
    private String strasse;

    private String strassennummer;
    private String plz;

    public Adresse() {
    }

    public Adresse(String stadt, String strasse, String strassennummer, String plz) {
        this.stadt = stadt;
        this.strasse = strasse;
        this.strassennummer = strassennummer;
        this.plz = plz;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrassennummer() {
        return strassennummer;
    }

    public void setStrassennummer(String strassennummer) {
        this.strassennummer = strassennummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", strasse='" + strasse + '\'' +
                ", strassennummer='" + strassennummer + '\'' +
                ", plz='" + plz + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse adresse)) return false;

        if (getId() != null ? !getId().equals(adresse.getId()) : adresse.getId() != null) return false;
        if (getStrasse() != null ? !getStrasse().equals(adresse.getStrasse()) : adresse.getStrasse() != null)
            return false;
        if (getStrassennummer() != null ? !getStrassennummer().equals(adresse.getStrassennummer()) : adresse.getStrassennummer() != null)
            return false;
        return getPlz() != null ? getPlz().equals(adresse.getPlz()) : adresse.getPlz() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStrasse() != null ? getStrasse().hashCode() : 0);
        result = 31 * result + (getStrassennummer() != null ? getStrassennummer().hashCode() : 0);
        result = 31 * result + (getPlz() != null ? getPlz().hashCode() : 0);
        return result;
    }
}
