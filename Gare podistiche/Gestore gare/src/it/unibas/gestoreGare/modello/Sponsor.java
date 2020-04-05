package it.unibas.gestoreGare.modello;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sponsor {

    private long id;
    private String nome;
    private String tipologia;
    private boolean italiano;
    private List<Atleta> atletiSponsorizzati;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public boolean isItaliano() {
        return italiano;
    }

    public void setItaliano(boolean italiano) {
        this.italiano = italiano;
    }

    @ManyToMany(mappedBy = "sponsorizzazioni")
    public List<Atleta> getAtletiSponsorizzati() {
        return atletiSponsorizzati;
    }

    public void setAtletiSponsorizzati(List<Atleta> atletiSponsorizzati) {
        this.atletiSponsorizzati = atletiSponsorizzati;
    }

}
