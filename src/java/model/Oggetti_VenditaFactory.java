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

/**
 *
 * @author marco
 */
public class Oggetti_VenditaFactory {
    private static Oggetti_VenditaFactory singleton;
    private ArrayList<Oggetti_Vendita> listaOggettiinVendita = new ArrayList<>();
    private String connectionString = null;
    private int count=0;
    public Oggetti_VenditaFactory() throws SQLException{
    }
    /**
     * @return the listaOggettiinVendita
     */
    public ArrayList<Oggetti_Vendita> getListaOggettiinVendita() throws SQLException {
        return listaOggettiinVendita;
        
    }
    
    public Oggetti_Vendita getListaOggettiinVenditaById(int id) throws SQLException {
        
         for(Oggetti_Vendita obj : getListaOggettiinVendita()){
            if(obj.getId() ==id)
                return obj;
        }
        return null;
    }
    
    public void addToList() throws SQLException
    {
        if(count==0)
        {
        Connection conn = DriverManager.getConnection(connectionString, "marcocauli", "0000");
        Statement stmt = conn.createStatement();
        String sql = "select * from oggetto";

             ResultSet set;
            set = stmt.executeQuery(sql);
             
             while (set.next()) {
             Oggetti_Vendita tmp = new Oggetti_Vendita();
             tmp.setId(set.getInt("id"));
             tmp.setNomeOggetto(set.getString("nome"));
             tmp.setnPezzi(set.getInt("npezzi"));
             tmp.setPrezzo(set.getDouble("prezzo"));
             tmp.setUrlImg(set.getString("img"));
             tmp.setDescrizione(set.getString("descrizione"));
             tmp.setVenditore(set.getString("venditore"));
             listaOggettiinVendita.add(tmp);
            }
             stmt.close();
         count++;
        }
    }
    
    public static Oggetti_VenditaFactory getInstance() throws SQLException {
        if (singleton == null) {
            singleton = new Oggetti_VenditaFactory();
        }
        return singleton;
    }

    /**
     * @param listaOggettiinVendita the listaOggettiinVendita to set
     */
    public void setListaOggettiinVendita(ArrayList<Oggetti_Vendita> listaOggettiinVendita) {
        this.listaOggettiinVendita = listaOggettiinVendita;
    }

    /**
     * @return the connectionString
     */
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * @param connectionString the connectionString to set
     */
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    public void createObject(String nome, int npezzi, double prezzo, String urlimg, String descrizione, String venditore) throws SQLException
    {
        Oggetti_Vendita tmp=new Oggetti_Vendita();
        tmp.setNomeOggetto(nome);
        tmp.setnPezzi(npezzi);
        tmp.setPrezzo(prezzo);
        tmp.setUrlImg(urlimg);
        tmp.setDescrizione(descrizione);
        tmp.setVenditore(venditore);
        listaOggettiinVendita.add(tmp);
        Connection conn = DriverManager.getConnection(UtenteFactory.getInstance().getConnectionString(), "marcocauli", "0000");
        Statement stmt = conn.createStatement();
        String sql = "insert into oggetto (id , nome , npezzi , prezzo , img , descrizione , venditore) VALUES "+
                "( default , '" + nome +"' , " + npezzi + " , " + prezzo +" , '" + urlimg + "' , '"+ descrizione +"' , '" + venditore +"' )";
            
            //stmt.execute(sql);
            stmt.executeUpdate(sql);
            //stmt.executeQuery(sql);
            stmt.close();
        
    }
    
    public void modifyObject(String nome, int npezzi, double prezzo, String urlimg, String descrizione, String venditore) throws SQLException
    {
        
        Oggetti_Vendita tmp = new Oggetti_Vendita();
        int i=0;
        tmp.setDescrizione(descrizione);
        tmp.setNomeOggetto(nome);
        tmp.setPrezzo(prezzo);
        tmp.setUrlImg(urlimg);
        tmp.setVenditore(venditore);
        tmp.setnPezzi(npezzi);
        Oggetti_Vendita tmp2 = new Oggetti_Vendita();
        while(!tmp.getNomeOggetto().equals(tmp2.getNomeOggetto()))
        {
            if(listaOggettiinVendita.get(i).getNomeOggetto()!=null)
                if(listaOggettiinVendita.get(i).getNomeOggetto().equals(tmp.getNomeOggetto()))
                {
                    tmp2=listaOggettiinVendita.get(i);
                    if(tmp2.getVenditore().equals(venditore))
                    {
                        listaOggettiinVendita.remove(tmp2);
                        listaOggettiinVendita.add(tmp);  
                        String sql = "UPDATE OGGETTO SET NPEZZI = " +tmp.getnPezzi() +", PREZZO = " + tmp.getPrezzo() +
                                ", IMG = '" + tmp.getUrlImg() + "', DESCRIZIONE = '" +tmp.getDescrizione() +"', VENDITORE = '" + tmp.getVenditore() + "' WHERE NOME = '" + tmp.getNomeOggetto()+ "'"; 
                        Connection conn = DriverManager.getConnection(UtenteFactory.getInstance().getConnectionString(), "marcocauli", "0000");
                        Statement stmt = conn.createStatement();    
                        stmt.executeUpdate(sql); 
                        stmt.close();
                    }
                }
            i++;
        }
        
                
        
    }
    
    public void deleteObject(String nome, int npezzi, double prezzo, String urlimg, String descrizione, String venditore) throws SQLException
    {
        
        Oggetti_Vendita tmp = new Oggetti_Vendita();
        int i=0;
        tmp.setDescrizione(descrizione);
        tmp.setNomeOggetto(nome);
        tmp.setPrezzo(prezzo);
        tmp.setUrlImg(urlimg);
        tmp.setVenditore(venditore);
        tmp.setnPezzi(npezzi);
        Oggetti_Vendita tmp2 = new Oggetti_Vendita();
        while(!tmp.getNomeOggetto().equals(tmp2.getNomeOggetto()))
        {
            if(listaOggettiinVendita.get(i).getNomeOggetto()!=null)
                if(listaOggettiinVendita.get(i).getNomeOggetto().equals(tmp.getNomeOggetto()))
                {
                    tmp2=listaOggettiinVendita.get(i);
                    if(tmp2.getVenditore().equals(venditore))
                    {
                        listaOggettiinVendita.remove(tmp2);
                        String sql = "DELETE FROM OGGETTO WHERE NOME = '" + tmp.getNomeOggetto()+ "'"; 
                        Connection conn = DriverManager.getConnection(UtenteFactory.getInstance().getConnectionString(), "marcocauli", "0000");
                        Statement stmt = conn.createStatement();    
                        stmt.executeUpdate(sql); 
                        stmt.close();
                    }
                }
            i++;
        }
        
                
        
    }
    
}
