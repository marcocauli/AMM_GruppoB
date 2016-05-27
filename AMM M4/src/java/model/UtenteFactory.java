/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class UtenteFactory {
    private static UtenteFactory singleton;
    private ArrayList<Clienti> listaclienti = new ArrayList<>();
    private ArrayList<Venditori> listavenditori = new ArrayList<>();
    private String connectionString;
    public UtenteFactory() throws SQLException{
        
    }
    public void addToList()
    {
        try {

             // creazione e apertura della connessione
             // si specifica la url, lo username e la password per il db
             Connection conn = DriverManager.getConnection(connectionString, "marcocauli", "0000");

             // utilizzo della connessione per inviare una query (select)
             Statement stmt = conn.createStatement();
             String sql = "select * from cliente ";

             ResultSet set;
            set = stmt.executeQuery(sql);
             
             while (set.next()) {
             Clienti tmp = new Clienti();
             tmp.setId(set.getInt("id"));
             tmp.setUsername(set.getString("username"));
             tmp.setPassword(set.getString("password"));
             String sql2 = "select * from saldo";
             Statement stmt2 = conn.createStatement();
             ResultSet set2 = stmt2.executeQuery(sql2);
             tmp.saldo= new Saldo_Clienti_Venditori();
             while(set2.next())
             {
                 if(set2.getInt("id")== tmp.getId())
                 {
                     tmp.saldo.setId(set2.getInt("id"));
                     tmp.saldo.setSaldo(set2.getDouble("saldo"));
                 }
             }
             listaclienti.add(tmp);
             }
             stmt.close();
             stmt = conn.createStatement();
             
             sql = "SELECT * FROM VENDITORE";
             set = stmt.executeQuery(sql);
             while (set.next()) {
             Venditori tmp = new Venditori();
             tmp.setId(set.getInt("id"));
             tmp.setUsername(set.getString("username"));
             tmp.setPassword(set.getString("password"));
             String sql2 = "select * from saldo";
             Statement stmt2 = conn.createStatement();
             ResultSet set2 = stmt2.executeQuery(sql2);
             tmp.saldo= new Saldo_Clienti_Venditori();
             while(set2.next())
             {
                 if(set2.getInt("id")== tmp.getId()+5)
                 {
                     tmp.saldo.setId(set2.getInt("id"));
                     tmp.saldo.setSaldo(set2.getDouble("saldo"));
                 }
             }
             listavenditori.add(tmp);
             }
             stmt.close();
             // chiusura della connessione
             conn.close();
        } catch (SQLException ex) {
             // nel caso la query fallisca (p.e. errori di sintassi)
             // viene sollevata una SQLException
             Logger.getLogger(UtenteFactory.class.getName()).
             log(Level.SEVERE, null, ex);
        }
    }
    
    public static UtenteFactory getInstance() throws SQLException {
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
    
    public Venditori getVenditoreByName(String username) {
        ArrayList<Venditori> venditori=getListavenditori();
        
         for(Venditori ven1 : venditori){
            if(ven1.getUsername().equals(username))
                return ven1;
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
    
    public void setConnectionString(String s){
        this.connectionString=s;
    }
    
    public String getConnectionString()
    {
        return this.connectionString;
    }
    
    public void aggiungiSaldoVenditore(double aggiungere, String username) throws SQLException
    {
        Venditori tmp2=getVenditoreByName(username);
        int id= tmp2.getId();
        id+=5;
        double somma=tmp2.saldo.getSaldo()+ aggiungere;
        String sql = "UPDATE SALDO SET SALDO = " + somma + " WHERE ID = " + id;
        Connection conn = DriverManager.getConnection(UtenteFactory.getInstance().getConnectionString(), "marcocauli", "0000");
        Statement stmt = conn.createStatement();    
        stmt.executeUpdate(sql); 
        stmt.close();

        
    }
}

