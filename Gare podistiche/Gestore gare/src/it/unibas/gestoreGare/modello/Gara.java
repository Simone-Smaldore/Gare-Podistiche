package it.unibas.gestoreGare.modello;

import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Gara {

    private long id;
    private String codice;
    private String descrizione;
    private double km;
    private Calendar dataGara;
    private List<Arrivo> arrivi;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getDataGara() {
        return dataGara;
    }

    public void setDataGara(Calendar dataGara) {
        this.dataGara = dataGara;
    }

    @OneToMany(mappedBy = "gara", cascade = CascadeType.ALL)
    public List<Arrivo> getArrivi() {
        return arrivi;
    }

    public void setArrivi(List<Arrivo> arrivi) {
        this.arrivi = arrivi;
    }

}
