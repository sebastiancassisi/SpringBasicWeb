/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.daos;

import ar.com.springbasicweb.beans.Admin;
import java.util.List;

/**
 *
 * @author cassisi
 */
public interface AdminDao {

    public void save(Admin admin);

    public List<Admin> findAll();

    public Admin findById(int id);

    public List<Admin> findByNombre(String nombre);

    public void update(Admin admin);

    public void delete(Admin admin);

}
