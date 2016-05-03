package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Admin;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional //Todos los metodos del dao deben ser transaccionales
@Repository //Le indico a Spring que esta clase se trata de un dao
public class AdminDaoImpl implements AdminDao {
    
    @Autowired //Le indico a Srpring que haga la inyección dependencias
    private SessionFactory sessionFactory;

    //Creo el metodo getSession para que me devuelva la sesion actial de hibernate.
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void save(Admin admin) {
        getSession().save(admin);
    }
    
    @Override
    public List<Admin> findAll() {        
        Query query = getSession().createQuery("from Admin");//Utilizo HQL. Admin es el nombre de la clases mapeada, la tabla es admin.
        return query.list();
        
    }
    
    @Override
    public Admin findById(int id) {
        Criteria crit = getSession().createCriteria(Admin.class);
        crit.add(Restrictions.eq("idAd", id));
        return (Admin) crit.uniqueResult();
    }
    
    @Override
    public List<Admin> findByNombre(String nombre) {
        Criteria crit = getSession().createCriteria(Admin.class);
        crit.add(Restrictions.like("nombre", "%" + nombre + "%"));
        return crit.list();
    }
    
    @Override
    public void update(Admin admin) {
        getSession().update(admin);
    }
    
    @Override
    public void delete(Admin admin) {
        getSession().delete(admin);
        
    }
    
}
