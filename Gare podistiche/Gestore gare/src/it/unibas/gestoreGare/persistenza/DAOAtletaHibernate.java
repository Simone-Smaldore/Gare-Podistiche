package it.unibas.gestoreGare.persistenza;

import it.unibas.gestoreGare.modello.Atleta;
import it.unibas.gestoreGare.persistenza.hibernate.DAOGenericoHibernate;

public class DAOAtletaHibernate extends DAOGenericoHibernate<Atleta> implements IDAOAtleta{
    
    public DAOAtletaHibernate() {
        super(Atleta.class);
    }
    
}
