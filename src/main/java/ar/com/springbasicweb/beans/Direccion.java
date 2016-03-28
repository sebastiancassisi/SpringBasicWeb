/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author cassisi
 */
@Component
public class Direccion {
    
    private String calle;
    private String cp;

    @Autowired
    public void setCalle(@Value("Suipacha 1250")String calle) {
        this.calle = calle;
    }
    
    @Autowired
    public void setCp(@Value("1722")String cp) {
        this.cp = cp;
    }
   
    public Direccion() {
    }

    public Direccion(String calle, String cp) {
        this.calle = calle;
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", cp=" + cp + '}';
    }
    
    
    
    
}
