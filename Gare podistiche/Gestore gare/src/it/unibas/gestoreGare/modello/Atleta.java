package it.unibas.gestoreGare.modello;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Atleta {

    private long id;
    private String nome;
    private String cognome;
    private String citta;
    private List<Arrivo> arrivi;
    private List<Sponsor> sponsorizzazioni;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    @OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
    public List<Arrivo> getArrivi() {
        return arrivi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setArrivi(List<Arrivo> arrivi) {
        this.arrivi = arrivi;
    }

    @ManyToMany(cascade =CascadeType.ALL)
    public List<Sponsor> getSponsorizzazioni() {
        return sponsorizzazioni;
    }

    public void setSponsorizzazioni(List<Sponsor> sponsorizzazioni) {
        this.sponsorizzazioni = sponsorizzazioni;
    }

}
