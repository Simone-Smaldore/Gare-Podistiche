package it.unibas.gestoreGare.test.modello;

import it.unibas.gestoreGare.modello.Atleta;
import it.unibas.gestoreGare.modello.OperatoreStatistica;
import it.unibas.gestoreGare.modello.Statistica;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class TestOperatoreStatistica extends TestCase{

    public void testOperatore() {
        OperatoreStatistica operatore = new OperatoreStatistica();
        Atleta atleta1 = new Atleta();
        atleta1.setCitta("Potenza");
        Atleta atleta2 = new Atleta();
        atleta2.setCitta("Potenza");
        Atleta atleta3 = new Atleta();
        atleta3.setCitta("Matera");
        List<Atleta> atleti = new ArrayList<>();
        atleti.add(atleta1);
        atleti.add(atleta2);
        atleti.add(atleta3);
        List<Statistica> statistiche = operatore.calcolaStatisticaAtleti(atleti);
        assertEquals(statistiche.size(), 2);
        Statistica statistica1 = statistiche.get(0);
        Statistica statistica2 = statistiche.get(1);
        if (statistica1.getCitta() == "Potenza") {
            assertEquals(statistica1.getPercentuale(), 66.66, 0.1);
            assertEquals(statistica2.getPercentuale(), 33.33, 0.1);
        } else {
            assertEquals(statistica2.getPercentuale(), 66.66, 0.1);
            assertEquals(statistica1.getPercentuale(), 33.33, 0.1);
        }
    }

}
