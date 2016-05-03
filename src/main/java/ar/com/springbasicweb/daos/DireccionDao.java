/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.beans.Direccion;
import java.util.List;

/**
 *
 * @author ANTI
 */
public interface DireccionDao {
    
    public void save(Direccion direccion);
    public List<Direccion> findAll(Admin admin); 
    
}
