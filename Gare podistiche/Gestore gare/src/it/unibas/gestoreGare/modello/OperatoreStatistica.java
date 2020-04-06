package it.unibas.gestoreGare.modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OperatoreStatistica {
    
    public List<Statistica> calcolaStatisticaAtleti(List<Atleta> atleti) {
        Map<String, Statistica> mappaAtleti = new HashMap<>();
        for (Atleta atleta : atleti) {
            if(mappaAtleti.get(atleta.getCitta()) == null) {
                Statistica statistica = new Statistica(atleta.getCitta(), 1, atleti.size());
                mappaAtleti.put(atleta.getCitta(), statistica);
                continue;
            }
            mappaAtleti.get(atleta.getCitta()).aggiungiOccorrenza();
        }
        return new ArrayList<Statistica> (mappaAtleti.values());
    }
}
