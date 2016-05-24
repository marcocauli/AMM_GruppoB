/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagecontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Oggetti_Vendita;
import model.Oggetti_VenditaFactory;
import model.UtenteFactory;

/**
 *
 * @author marco
 */
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        if(session.getAttribute("loggedIn")==null)
        {
           request.getRequestDispatcher("Unauthorized.jsp").forward(request, response); 
        }
        if((boolean)session.getAttribute("loggedIn")==true && session.getAttribute("Utente")=="venditore"){
            if(request.getParameter("Submit")==null)
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            
            if(request.getParameter("Submit")!=null){
                String nome = request.getParameter("name");
                String imgURL = request.getParameter("url");
                String descrizione=request.getParameter("descrizione");
                Integer prezzo = Integer.parseInt(request.getParameter("prezzo"));
                Integer nPezzi = Integer.parseInt(request.getParameter("npezzi"));
                request.setAttribute("Saldo",UtenteFactory.getInstance().getUtenteById((Integer)session.getAttribute("id")).saldo.getSaldo());
                if(nome.equals("") || imgURL.equals("") || prezzo<=1 || descrizione.equals("") || nPezzi<=1){
                    request.setAttribute("completo", false);
                }
                else{
                    Oggetti_Vendita oggetto= new Oggetti_Vendita();
                    oggetto.setNomeOggetto(nome);
                    oggetto.setUrlImg(imgURL);
                    oggetto.setDescrizione(descrizione);
                    oggetto.setPrezzo(prezzo);
                    oggetto.setnPezzi(nPezzi);
                    request.setAttribute("oggetto", oggetto);
                    Oggetti_VenditaFactory.getInstance().createObject(nome, nPezzi, prezzo, imgURL, descrizione, (String) session.getAttribute("Nome"));
                    request.getRequestDispatcher("inserito.jsp").forward(request, response);
                }
                
            }
            
            if(request.getParameter("SubmitMod")!=null){
                String nome = request.getParameter("name");
                String imgURL = request.getParameter("url");
                String descrizione=request.getParameter("descrizione");
                Integer prezzo = Integer.parseInt(request.getParameter("prezzo"));
                Integer nPezzi = Integer.parseInt(request.getParameter("npezzi"));
                request.setAttribute("Saldo",UtenteFactory.getInstance().getUtenteById((Integer)session.getAttribute("id")).saldo.getSaldo());
                if(nome.equals("") || imgURL.equals("") || prezzo<=1 || descrizione.equals("") || nPezzi<=1){
                    request.setAttribute("completo", false);
                }
                else{
                    Oggetti_Vendita oggetto= new Oggetti_Vendita();
                    oggetto.setNomeOggetto(nome);
                    oggetto.setUrlImg(imgURL);
                    oggetto.setDescrizione(descrizione);
                    oggetto.setPrezzo(prezzo);
                    oggetto.setnPezzi(nPezzi);
                    request.setAttribute("oggetto", oggetto);
                    Oggetti_VenditaFactory.getInstance().modifyObject(nome, nPezzi, prezzo, imgURL, descrizione, (String) session.getAttribute("Nome"));
                }
                
            }
            
            if(request.getParameter("SubmitDel")!=null){
                String nome = request.getParameter("name");
                String imgURL = request.getParameter("url");
                String descrizione=request.getParameter("descrizione");
                Integer prezzo = Integer.parseInt(request.getParameter("prezzo"));
                Integer nPezzi = Integer.parseInt(request.getParameter("npezzi"));
                request.setAttribute("Saldo",UtenteFactory.getInstance().getUtenteById((Integer)session.getAttribute("id")).saldo.getSaldo());
                if(nome.equals("") || imgURL.equals("") || prezzo<=1 || descrizione.equals("") || nPezzi<=1){
                    request.setAttribute("completo", false);
                }
                else{
                    Oggetti_Vendita oggetto= new Oggetti_Vendita();
                    oggetto.setNomeOggetto(nome);
                    oggetto.setUrlImg(imgURL);
                    oggetto.setDescrizione(descrizione);
                    oggetto.setPrezzo(prezzo);
                    oggetto.setnPezzi(nPezzi);
                    request.setAttribute("oggetto", oggetto);
                    Oggetti_VenditaFactory.getInstance().deleteObject(nome, nPezzi, prezzo, imgURL, descrizione, (String) session.getAttribute("Nome"));
                }
                
            }
            
             
        }
        
        if((boolean)session.getAttribute("loggedIn")==true && session.getAttribute("Utente")=="cliente"){
                    request.getRequestDispatcher("Unauthorized.jsp").forward(request, response);
             }
         if((boolean)session.getAttribute("loggedIn")==false && session.getAttribute("Utente")==null){
                    request.getRequestDispatcher("login.jsp").forward(request, response);
             }
         if(request.getAttribute("completo")!=null)
         {
             request.getRequestDispatcher("venditore.jsp").forward(request, response);
         }
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Venditore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Venditore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
