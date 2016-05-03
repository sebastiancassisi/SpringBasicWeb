
package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Usuario;
import java.util.List;


public interface UsuarioDao {

public Usuario findByUsername(String usuario);    
public void save(Usuario usuario);
public List<Usuario> findAll();
    
}
