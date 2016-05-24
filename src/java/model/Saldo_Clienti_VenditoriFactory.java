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
public class Saldo_Clienti_VenditoriFactory {
    private static Saldo_Clienti_VenditoriFactory singleton;
    private ArrayList<Saldo_Clienti_Venditori> listaSaldo = new ArrayList<>();
    
    public Saldo_Clienti_VenditoriFactory(){
        Saldo_Clienti_Venditori scv1=new Saldo_Clienti_Venditori();
        scv1.setId(0);
        scv1.setSaldo(81.32);
        
        Saldo_Clienti_Venditori scv2=new Saldo_Clienti_Venditori();
        scv2.setId(1);
        scv2.setSaldo(1025.36);
        
        Saldo_Clienti_Venditori scv3=new Saldo_Clienti_Venditori();
        scv3.setId(2);
        scv3.setSaldo(101.72);
        
        Saldo_Clienti_Venditori scv4=new Saldo_Clienti_Venditori();
        scv4.setId(3);
        scv4.setSaldo(156.55);
        
        Saldo_Clienti_Venditori scv5=new Saldo_Clienti_Venditori();
        scv5.setId(4);
        scv5.setSaldo(156.55);
        
        listaSaldo.add(scv1);
        listaSaldo.add(scv2);
        listaSaldo.add(scv3);
        listaSaldo.add(scv4);
        listaSaldo.add(scv5);
        
    }
    
    public Saldo_Clienti_Venditori getSaldobyId(int id){
        for(Saldo_Clienti_Venditori saldo : listaSaldo){
            if(saldo.getId() == id)
                return saldo;
        }
        return null;
    }
    
    public static Saldo_Clienti_VenditoriFactory getInstance() {
        if (singleton == null) {
            singleton = new Saldo_Clienti_VenditoriFactory();
        }
        return singleton;
    }
}
