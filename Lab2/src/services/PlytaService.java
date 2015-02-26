/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Plyta;
import javax.persistence.EntityManager;

/**
 *
 * @author student
 */
public class PlytaService {
    protected EntityManager manager;
    
    
    public PlytaService(EntityManager em){
        this.manager=em;
    }
    
    public Plyta create(String nazwa, String autor, int liczbaUtworow, double cena){
        Plyta plyta = new Plyta();
        
        plyta.setNazwa(nazwa);
        plyta.setAutor(autor);
        plyta.setLiczbaUtworow(liczbaUtworow);
        plyta.setCena(cena);
        
        manager.persist(plyta);
        return plyta;
        
    }
}
