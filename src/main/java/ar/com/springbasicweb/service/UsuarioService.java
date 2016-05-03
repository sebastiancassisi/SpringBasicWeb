package ar.com.springbasicweb.service;

import ar.com.springbasicweb.beans.Usuario;
import ar.com.springbasicweb.daos.UsuarioDao;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
  	public void save(Usuario usuario) {
		usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
		String claveUsr = usuario.getClave();
		usuario.setClave(passwordEncoder.encode(claveUsr));
		usuarioDao.save(usuario);
	}

    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
}
