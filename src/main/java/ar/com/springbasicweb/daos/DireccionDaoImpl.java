package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.beans.Direccion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional //Todos los metodos del dao deben ser transaccionales
@Repository //Le indico a Spring que esta clase se trata de un dao
public class DireccionDaoImpl implements DireccionDao{

        @Autowired //Le indico a Srpring que haga la inyección dependencias
    private SessionFactory sessionFactory;

    //Creo el metodo getSession para que me devuelva la sesion actial de hibernate.
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    
    @Override
    public void save(Direccion direccion) {
       
        getSession().save(direccion);
        
    }

    @Override
    //Me trae todas las direcciones que tiene un Admin
    public List<Direccion> findAll(Admin admin) {
        Criteria crit = getSession().createCriteria(Direccion.class)
                .setFetchMode("admin", FetchMode.JOIN)
                .add(Restrictions.eq("admin.idAd", admin.getIdAd()))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        
        return crit.list();
    }
    
}
