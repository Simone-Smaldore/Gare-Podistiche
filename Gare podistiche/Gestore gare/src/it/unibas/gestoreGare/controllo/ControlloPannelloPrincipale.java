package it.unibas.gestoreGare.controllo;

import it.unibas.gestoreGare.Applicazione;
import it.unibas.gestoreGare.Costanti;
import it.unibas.gestoreGare.modello.Gara;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPannelloPrincipale {

    private Action azioneCerca = new AzioneCerca();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca gare");
            this.putValue(SHORT_DESCRIPTION, "Cerca le gare con un massimo di chilometri inseriti");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl C"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String chilometri = Applicazione.getInstance().getPannelloPrincipale().getValoreKm();
            String errori = trovaErrori(chilometri);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraErrori(errori);
                return;
            }
            double km = Double.parseDouble(chilometri);
            try {
                DAOUtilHibernate.beginTransaction();
                List<Gara> gare = Applicazione.getInstance().getDaoGara().getGaraPerMassimoChilometraggio(km);
                Applicazione.getInstance().getModello().putBean(Costanti.GARE, gare);
                Applicazione.getInstance().getPannelloPrincipale().aggiornaTabella();
                DAOUtilHibernate.commit();
            } catch (DAOException ex) {
                DAOUtilHibernate.rollback();
                Applicazione.getInstance().getFrame().mostraErrori("Impossibile accedere al DB " + ex.getMessage());
            }
        }

        private String trovaErrori(String chilometri) {
            String errori = "";
            if (chilometri.isEmpty()) {
                errori += "Inserire un campo per i chilometri";
                return errori;
            }
            try {
                double km = Double.parseDouble(chilometri);
                if (km <= 0) {
                    errori += "inserire un valore positivo per i chilometri";
                }
            } catch (NumberFormatException ex) {
                errori += "Inserire un numero per i chilometri";
            }
            return errori;
        }

    }
}
