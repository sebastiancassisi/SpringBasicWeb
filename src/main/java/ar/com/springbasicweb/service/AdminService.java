/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.service;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.daos.AdminDao;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANTI
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean save(Admin admin) {

        admin.setFechaCreacion(new Timestamp(new Date().getTime()));

        return adminDao.save(admin);
    }

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    public boolean saveOrUpdate(Admin admin) {

        if (admin.getIdAd() == 0) {
            //Insert
            admin.setFechaCreacion(new Timestamp(new Date().getTime()));
            return adminDao.save(admin);
        } else {
            //Update
            return adminDao.update(admin);
        }

    }

    public boolean delete(int idAd) {
       return adminDao.delete(idAd);
    }

}
