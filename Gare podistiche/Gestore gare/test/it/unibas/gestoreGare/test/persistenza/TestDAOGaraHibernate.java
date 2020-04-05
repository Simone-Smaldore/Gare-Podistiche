package it.unibas.gestoreGare.test.persistenza;

import it.unibas.gestoreGare.modello.Gara;
import it.unibas.gestoreGare.persistenza.DAOGaraHibernate;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.DAOUtilHibernate;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDAOGaraHibernate extends TestCase {

    private static Logger logger = LoggerFactory.getLogger(TestDAOGaraHibernate.class);

    public void testRicercaPerkm() {
        DAOGaraHibernate daoGara = new DAOGaraHibernate();
        Gara gara1 = new Gara();
        gara1.setCodice("prova1");
        gara1.setDataGara(new GregorianCalendar());
        gara1.setDescrizione("prova1");
        gara1.setKm(0.000001);
        Gara gara2 = new Gara();
        gara2.setCodice("prova2");
        gara2.setDataGara(new GregorianCalendar());
        gara2.setDescrizione("prova2");
        gara2.setKm(0.000002);
        try {
            DAOUtilHibernate.beginTransaction();
            List<Gara> gare15km = daoGara.getGaraPerMassimoChilometraggio(0.0000015);
            List<Gara> gare25km = daoGara.getGaraPerMassimoChilometraggio(0.0000025);
            assertEquals(gare15km.size(), 0);
            assertEquals(gare25km.size(), 0);
            daoGara.makePersistent(gara1);
            daoGara.makePersistent(gara2);            
            gare15km = daoGara.getGaraPerMassimoChilometraggio(0.0000015);
            gare25km = daoGara.getGaraPerMassimoChilometraggio(0.0000025);
            assertEquals(gare15km.size(), 1);
            assertEquals(gare25km.size(), 2);
            daoGara.makeTransient(gara1);
            daoGara.makeTransient(gara2);
            gare15km = daoGara.getGaraPerMassimoChilometraggio(0.0000015);
            gare25km = daoGara.getGaraPerMassimoChilometraggio(0.0000025);
            assertEquals(gare15km.size(), 0);
            assertEquals(gare25km.size(), 0);            
            DAOUtilHibernate.commit();
        } catch (DAOException ex) {
            DAOUtilHibernate.rollback();
            logger.debug("***ERRORE NELLA CONNESSIONE AL DB " + ex.getMessage());
            fail();
        }
    }

}
