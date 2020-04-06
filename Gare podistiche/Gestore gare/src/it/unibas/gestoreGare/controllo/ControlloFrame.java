package it.unibas.gestoreGare.controllo;

import it.unibas.gestoreGare.Applicazione;
import it.unibas.gestoreGare.Costanti;
import it.unibas.gestoreGare.modello.Atleta;
import it.unibas.gestoreGare.modello.OperatoreStatistica;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloFrame {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCalcolaStatistiche = new AzioneCalcolaStatistiche();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCalcolaStatistiche() {
        return azioneCalcolaStatistiche;
    }

    private class AzioneCalcolaStatistiche extends AbstractAction {

        public AzioneCalcolaStatistiche() {
            this.putValue(NAME, "Calcola Statistiche");
            this.putValue(SHORT_DESCRIPTION, "Calcola le statistiche degli atletti per citta");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            OperatoreStatistica operatore = new OperatoreStatistica();
            try {
                DAOUtilHibernate.beginTransaction();
                List<Atleta> atleti = Applicazione.getInstance().getDaoAtleta().findAll();
                Applicazione.getInstance().getModello().putBean(Costanti.STATISTICHE, operatore.calcolaStatisticaAtleti(atleti));
                DAOUtilHibernate.commit();
                Applicazione.getInstance().getFinestraStatistiche().visualizza();
            } catch (DAOException ex) {
                DAOUtilHibernate.rollback();
                Applicazione.getInstance().getFrame().mostraErrori("Impossibile accedere al DB " + ex.getMessage());
            }
        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
