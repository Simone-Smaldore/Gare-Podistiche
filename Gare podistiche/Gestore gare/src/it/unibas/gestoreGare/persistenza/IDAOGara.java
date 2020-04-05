package it.unibas.gestoreGare.persistenza;

import it.unibas.gestoreGare.modello.Gara;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.IDAOGenerico;
import java.util.List;


public interface IDAOGara extends IDAOGenerico<Gara>{
    
    public List<Gara> getGaraPerMassimoChilometraggio(double km) throws DAOException;
    
}
