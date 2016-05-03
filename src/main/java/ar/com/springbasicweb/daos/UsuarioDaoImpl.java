package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Usuario findByUsername(String nombre) {
        Criteria crit = getSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("nombre", nombre));

        return (Usuario) crit.uniqueResult();
    }

    @Override
    public void save(Usuario usuario) {
        getSession().save(usuario);
    }

  	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return getSession().createQuery("from Usuario")
				.list();
	}

}
