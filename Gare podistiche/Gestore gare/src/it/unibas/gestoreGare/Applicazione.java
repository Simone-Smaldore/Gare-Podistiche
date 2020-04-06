package it.unibas.gestoreGare;

import it.unibas.gestoreGare.controllo.ControlloFinestraAggiungiRisultato;
import it.unibas.gestoreGare.controllo.ControlloFrame;
import it.unibas.gestoreGare.controllo.ControlloPannelloPrincipale;
import it.unibas.gestoreGare.modello.Modello;
import it.unibas.gestoreGare.persistenza.DAOAtletaHibernate;
import it.unibas.gestoreGare.persistenza.DAOGaraHibernate;
import it.unibas.gestoreGare.persistenza.IDAOAtleta;
import it.unibas.gestoreGare.persistenza.IDAOGara;
import it.unibas.gestoreGare.vista.FinestraAggiungiRisultato;
import it.unibas.gestoreGare.vista.FinestraStatistiche;
import it.unibas.gestoreGare.vista.Frame;
import it.unibas.gestoreGare.vista.PannelloPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    private Modello modello;
    private IDAOAtleta daoAtleta;
    private IDAOGara daoGara;
    private FinestraStatistiche finestraStatistiche;
    private FinestraAggiungiRisultato finestraAggiungiRisultato;
    private Frame frame;
    private PannelloPrincipale pannelloPrincipale;
    private ControlloPannelloPrincipale controlloPannelloPrincipale;
    private ControlloFrame controlloFrame;
    private ControlloFinestraAggiungiRisultato controlloFinsetraAggiungiRisultato;

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    public void inizializza() {
        this.modello = new Modello();
        this.controlloFrame = new ControlloFrame();
        this.controlloPannelloPrincipale = new ControlloPannelloPrincipale();
        this.controlloFinsetraAggiungiRisultato = new ControlloFinestraAggiungiRisultato();
        this.daoAtleta = new DAOAtletaHibernate();
        this.daoGara = new DAOGaraHibernate();
        this.frame = new Frame();
        this.pannelloPrincipale = new PannelloPrincipale();
        this.finestraAggiungiRisultato = new FinestraAggiungiRisultato(frame);
        this.finestraStatistiche = new FinestraStatistiche(frame);
        this.pannelloPrincipale.inizializza();
        this.finestraAggiungiRisultato.inizializza();
        this.finestraStatistiche.inizializza();
        this.frame.inizializza();
    }

    public ControlloFinestraAggiungiRisultato getControlloFinsetraAggiungiRisultato() {
        return controlloFinsetraAggiungiRisultato;
    }

    public FinestraAggiungiRisultato getFinestraAggiungiRisultato() {
        return finestraAggiungiRisultato;
    }

    public PannelloPrincipale getPannelloPrincipale() {
        return pannelloPrincipale;
    }

    public ControlloPannelloPrincipale getControlloPannelloPrincipale() {
        return controlloPannelloPrincipale;
    }

    public FinestraStatistiche getFinestraStatistiche() {
        return finestraStatistiche;
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOAtleta getDaoAtleta() {
        return daoAtleta;
    }

    public IDAOGara getDaoGara() {
        return daoGara;
    }

    public Frame getFrame() {
        return frame;
    }

    public ControlloFrame getControlloFrame() {
        return controlloFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }
}
