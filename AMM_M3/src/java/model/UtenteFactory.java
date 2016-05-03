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
public class UtenteFactory {
    private static UtenteFactory singleton;
    private ArrayList<Clienti> listaclienti = new ArrayList<>();
    private ArrayList<Venditori> listavenditori = new ArrayList<>();
    public UtenteFactory(){
        Clienti cliente1 = new Clienti();
        cliente1.setUsername("cliente1");
        cliente1.setPassword("1");
        cliente1.setId(0);
        cliente1.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(0);
        listaclienti.add(cliente1);
        
        Clienti cliente2 = new Clienti();
        cliente2.setUsername("cliente2");
        cliente2.setPassword("2");
        cliente2.setId(1);
        cliente2.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(1);
        listaclienti.add(cliente2);
        
        Clienti cliente3 = new Clienti();
        cliente3.setUsername("cliente3");
        cliente3.setPassword("3");
        cliente3.setId(2);
        cliente3.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(2);        
        listaclienti.add(cliente3);
        
        Clienti cliente4 = new Clienti();
        cliente4.setUsername("cliente4");
        cliente4.setPassword("4");
        cliente4.setId(3);
        cliente4.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(3);
        listaclienti.add(cliente4);
        
        Clienti cliente5 = new Clienti();
        cliente5.setUsername("cliente5");
        cliente5.setPassword("5");
        cliente5.setId(4);
        cliente5.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(4);
        listaclienti.add(cliente5);
        
        Venditori venditore1= new Venditori();
        venditore1.setId(5);
        venditore1.setUsername("venditore1");
        venditore1.setPassword("1");
        venditore1.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(1);
        listavenditori.add(venditore1);
        
        
        Venditori venditore2= new Venditori();
        venditore2.setId(6);
        venditore2.setUsername("venditore2");
        venditore2.setPassword("2");
        venditore2.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(0);
        listavenditori.add(venditore2);
        
        
        Venditori venditore3= new Venditori();
        venditore3.setId(7);
        venditore3.setUsername("venditore3");
        venditore3.setPassword("3");
        venditore3.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(3);
        listavenditori.add(venditore3);
        
        
        
        Venditori venditore4= new Venditori();
        venditore4.setId(8);
        venditore4.setUsername("venditore4");
        venditore4.setPassword("4");
        venditore4.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(2);
        listavenditori.add(venditore4);
        
        
        Venditori venditore5= new Venditori();
        venditore5.setId(9);
        venditore5.setUsername("venditore5");
        venditore5.setPassword("5");
        venditore5.saldo=Saldo_Clienti_VenditoriFactory.getInstance().getSaldobyId(4);
        listavenditori.add(venditore5);
    }
    
    
    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }
    /**
     * @return the listaclienti
     */
    public ArrayList<Clienti> getListaclienti() {
        return listaclienti;
    }
    
    public Clienti getClientebyId(int id) {
        ArrayList<Clienti> clienti=getListaclienti();
        
         for(Clienti cl1 : clienti){
            if(cl1.getId() == id)
                return cl1;
        }
        return null;
        
    }
    
    /**
     * @return the listavenditori
     */
    public ArrayList<Venditori> getListavenditori() {
        return listavenditori;
    }
    
    public ArrayList<Utente> getUtenti()
    {
        ArrayList<Utente> listautenti=new ArrayList<>();
        listautenti.addAll(listaclienti);
        listautenti.addAll(listavenditori);
        return listautenti;
    }
    public Utente getUtenteById(int id)
    {
        ArrayList<Utente> utenti=getUtenti();
        
         for(Utente user : utenti){
            if(user.getId() == id)
                return user;
        }
        return null;
    }
}
