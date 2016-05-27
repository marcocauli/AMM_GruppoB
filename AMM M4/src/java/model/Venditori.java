/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Venditori extends Utente{
    
    private ArrayList<Oggetti_Vendita> oggettiVendita; 
    
    //Costruttore
    public Venditori()
    {
        super();
        oggettiVendita = new ArrayList<>();
    }  
    
    //Metodi
    
    //@return oggettiOwned
     public ArrayList<Oggetti_Vendita> getoggettiVendita() {
        return oggettiVendita;
    }

    //OggettiOwned to set
    public void setoggettiVendita(ArrayList<Oggetti_Vendita> oggettiVendita) {
        this.oggettiVendita = oggettiVendita;
    } 
    
    
}
    

