/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class Oggetti_Vendita {
    private String nomeOggetto;
    private int nPezzi;
    private double prezzo;
    private int id;
    private String urlimg;
    private String descrizione;
    
    public Oggetti_Vendita(){
        nomeOggetto="null";
        nPezzi=-1;
        prezzo=-1.0;
        id=-1;
        urlimg="";
        descrizione="";
    }
    
    public String getUrlImg(){
    return urlimg;
    }
    
    public String setUrlImg(String url){
    urlimg=url;
    return urlimg;
    }
    
    /**
     * @return the nomeOggetto
     */
    public String getNomeOggetto() {
        return nomeOggetto;
    }

    /**
     * @param nomeOggetto the nomeOggetto to set
     */
    public void setNomeOggetto(String nomeOggetto) {
        this.nomeOggetto = nomeOggetto;
    }

    /**
     * @return the nPezzi
     */
    public int getnPezzi() {
        return nPezzi;
    }

    /**
     * @param nPezzi the nPezzi to set
     */
    public void setnPezzi(int nPezzi) {
        this.nPezzi = nPezzi;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
