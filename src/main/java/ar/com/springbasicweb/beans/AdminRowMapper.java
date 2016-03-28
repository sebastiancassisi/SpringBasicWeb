/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ANTI
 */
public class AdminRowMapper implements RowMapper<Admin>{

    @Override
    public Admin mapRow(ResultSet rs, int i) throws SQLException {
        Admin admin = new Admin();
             
             admin.setIdAd(rs.getInt("idAd"));
             admin.setCargo(rs.getString("cargo"));
             admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
             admin.setNombre(rs.getString("nombre"));
             
             return admin;
    }
    
}
