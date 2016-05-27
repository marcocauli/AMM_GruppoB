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
public class Clienti extends Utente{
    private ArrayList<Oggetti_Vendita> oggetticomprati;
    
    public Clienti ()
    {
        super();
        oggetticomprati=new ArrayList();
    }  

    /**
     * @return the oggetticomprati
     */
    public ArrayList<Oggetti_Vendita> getOggetticomprati() {
        return oggetticomprati;
    }

    /**
     * @param oggetticomprati the oggetticomprati to set
     */
    public void setOggetticomprati(ArrayList<Oggetti_Vendita> oggetticomprati) {
        this.oggetticomprati = oggetticomprati;
    }
}
