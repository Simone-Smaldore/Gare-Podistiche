package it.unibas.gestoreGare.controllo;

import it.unibas.gestoreGare.Applicazione;
import it.unibas.gestoreGare.Costanti;
import it.unibas.gestoreGare.modello.Arrivo;
import it.unibas.gestoreGare.modello.Atleta;
import it.unibas.gestoreGare.modello.Gara;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloFinestraAggiungiRisultato {

    private Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi risultato");
            this.putValue(SHORT_DESCRIPTION, "Aggiunge il risultato dell' atleta alla gara");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl A"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Atleta atleta = Applicazione.getInstance().getFinestraAggiungiRisultato().getAtletaSelezionato();
            Calendar orario = Applicazione.getInstance().getFinestraAggiungiRisultato().getOraSelezionata();
            Gara garaSelezionata = (Gara) Applicazione.getInstance().getModello().getBean(Costanti.GARA_SELEZIONATA);
            Calendar orarioGara = garaSelezionata.getDataGara();
            String errori = trovaErrori(orario, orarioGara, atleta, garaSelezionata);
            if(!errori.isEmpty()) {
                Applicazione.getInstance().getFinestraAggiungiRisultato().mostraErrori(errori);
                return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                Applicazione.getInstance().getDaoGara().makePersistent(garaSelezionata);
                Applicazione.getInstance().getDaoAtleta().makePersistent(atleta);
                Arrivo arrivo = new Arrivo();
                arrivo.setAtleta(atleta);
                arrivo.setOrarioArrivo(orario);
                arrivo.setGara(garaSelezionata);
                garaSelezionata.addRisultato(arrivo);
                Applicazione.getInstance().getFinestraAggiungiRisultato().aggiornaTabella();
                DAOUtilHibernate.commit();
            } catch (DAOException ex) {
                DAOUtilHibernate.rollback();
                Applicazione.getInstance().getFinestraAggiungiRisultato().mostraErrori("Impossibile connettersi al DB" + ex.getMessage());
            }
        }

        private String trovaErrori(Calendar orarioArrivo, Calendar orarioGara, Atleta atleta, Gara garaSelezionata) {
            String errori = "";
            if (orarioArrivo.get(Calendar.HOUR_OF_DAY) < orarioGara.get(Calendar.HOUR_OF_DAY)
                    || (orarioArrivo.get(Calendar.HOUR_OF_DAY) == orarioGara.get(Calendar.HOUR_OF_DAY) && orarioArrivo.get(Calendar.MINUTE) < orarioGara.get(Calendar.MINUTE))) {
                errori += "Errore orario precedente a quello di partenza\n";
            }
            for (Arrivo arrivo : garaSelezionata.getArrivi()) {
                if(arrivo.getAtleta().getId() == (atleta.getId())) {
                    errori += "Risultato già registrato per l'atleta";
                }
            }
            return errori;
        }

    }
}
