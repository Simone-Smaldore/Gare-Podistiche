package it.unibas.gestoreGare.persistenza;

import it.unibas.gestoreGare.modello.Gara;
import it.unibas.gestoreGare.persistenza.hibernate.DAOException;
import it.unibas.gestoreGare.persistenza.hibernate.DAOGenericoHibernate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DAOGaraHibernate extends DAOGenericoHibernate<Gara> implements IDAOGara{

    public DAOGaraHibernate() {
        super(Gara.class);
    }

    @Override
    public List<Gara> getGaraPerMassimoChilometraggio(double km) throws DAOException {
        Criteria criterio = getSession().createCriteria(Gara.class);
        criterio.add(Restrictions.lt("km", km));
        criterio.addOrder(Order.asc("km"));
        return criterio.list();
    }
    
}
