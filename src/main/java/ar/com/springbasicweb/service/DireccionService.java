
package ar.com.springbasicweb.service;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.beans.Direccion;
import ar.com.springbasicweb.daos.AdminDao;
import ar.com.springbasicweb.daos.DireccionDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
  
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private DireccionDao direccionDao;
    
    public void save(Admin admin, Direccion direccion){
    
        direccion.setAdmin(admin);
        direccionDao.save(direccion);
        
    }
    
    public List<Direccion> findAll(int IdAd){
        Admin admin = adminDao.findById(IdAd);
    return direccionDao.findAll(admin);
    }
}
