package it.unibas.gestoreGare.modello;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Arrivo {

    private long id;
    private Calendar orarioArrivo;
    private Atleta atleta;
    private Gara gara;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(Calendar orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    @ManyToOne()
    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @ManyToOne()
    public Gara getGara() {
        return gara;
    }

    public void setGara(Gara gara) {
        this.gara = gara;
    }

}
