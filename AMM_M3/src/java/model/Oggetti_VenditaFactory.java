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
public class Oggetti_VenditaFactory {
    private static Oggetti_VenditaFactory singleton;
    private ArrayList<Oggetti_Vendita> listaOggettiinVendita = new ArrayList<>();
    
    public Oggetti_VenditaFactory(){
        
        Oggetti_Vendita RAM= new Oggetti_Vendita();
        RAM.setNomeOggetto("RAM");
        RAM.setId(100);
        RAM.setPrezzo(10);
        RAM.setnPezzi(46);
        RAM.setUrlImg("M3/img/RAM.jpg");
        RAM.setDescrizione("RAM ad alte prestazioni");
        
        Oggetti_Vendita PC= new Oggetti_Vendita();
        PC.setNomeOggetto("PC");
        PC.setUrlImg("M3/img/pc.jpg");
        PC.setId(101);
        PC.setPrezzo(1000);
        PC.setnPezzi(6);
        PC.setDescrizione("PC ad alte prestazioni");
        
        Oggetti_Vendita tastiera= new Oggetti_Vendita();
        tastiera.setUrlImg("M3/img/tastiera.jpg");
        tastiera.setNomeOggetto("tastiera");
        tastiera.setId(102);
        tastiera.setPrezzo(30);
        tastiera.setnPezzi(53);
        tastiera.setDescrizione("tastiera ad alte prestazioni");
        
        Oggetti_Vendita mouse= new Oggetti_Vendita();
        mouse.setUrlImg("M3/img/mouse.jpg");
        mouse.setNomeOggetto("mouse");
        mouse.setId(103);
        mouse.setPrezzo(20);
        mouse.setnPezzi(11);
        mouse.setDescrizione("mouse ad alte prestazioni");
        
        listaOggettiinVendita.add(PC);
        listaOggettiinVendita.add(RAM);
        listaOggettiinVendita.add(tastiera);
        listaOggettiinVendita.add(mouse);
        
    }

    /**
     * @return the listaOggettiinVendita
     */
    public ArrayList<Oggetti_Vendita> getListaOggettiinVendita() {
        return listaOggettiinVendita;
    }
    
    public Oggetti_Vendita getListaOggettiinVenditaById(int id) {
        
         for(Oggetti_Vendita obj : listaOggettiinVendita){
            if(obj.getId() ==id)
                return obj;
        }
        return null;
    }
    
    public static Oggetti_VenditaFactory getInstance() {
        if (singleton == null) {
            singleton = new Oggetti_VenditaFactory();
        }
        return singleton;
    }
}
