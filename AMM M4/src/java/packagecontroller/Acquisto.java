/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagecontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author marco
 */
@WebServlet(name = "Acquisto", urlPatterns = {"/acquisto.html"})
public class Acquisto extends HttpServlet {

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
        
        
        if(request.getParameter("invio_oggetti")!=null)
        {
            
            Integer id=(Integer) session.getAttribute("id");
            Utente cliente = UtenteFactory.getInstance().getUtenteById(id);
            
            String idogg=request.getParameter("idogg");
            Oggetti_Vendita oggetto= Oggetti_VenditaFactory.getInstance().getListaOggettiinVenditaById(Integer.parseInt(idogg));
            if( cliente.saldo.getSaldo() > oggetto.getPrezzo()){
                        //UtenteFactory.getInstance().getUtenti().remove(cliente);
                        //Oggetti_VenditaFactory.getInstance().getListaOggettiinVendita().remove(oggetto);
                       
                        if( oggetto.getnPezzi() == 0){
                            request.setAttribute("Acquisto", "Oggetti terminati");
                            request.setAttribute("oggetto",oggetto);
                            request.getRequestDispatcher("riepilogo_Acquisto.jsp").forward(request, response);
                        }
                        else{
                            oggetto.setnPezzi(oggetto.getnPezzi()-1);
                            Oggetti_VenditaFactory.getInstance().modifyObject(oggetto.getNomeOggetto(), oggetto.getnPezzi(), oggetto.getPrezzo(), oggetto.getUrlImg(), oggetto.getDescrizione(), oggetto.getVenditore());
                            cliente.saldo.setSaldo(cliente.saldo.getSaldo() - oggetto.getPrezzo());
                            String sql = "UPDATE SALDO SET SALDO = " + cliente.saldo.getSaldo() + "WHERE ID = " + cliente.getId();
                            Connection conn = DriverManager.getConnection(UtenteFactory.getInstance().getConnectionString(), "marcocauli", "0000");
                            Statement stmt = conn.createStatement();    
                            stmt.executeUpdate(sql); 
                            stmt.close();
                            UtenteFactory.getInstance().aggiungiSaldoVenditore(oggetto.getPrezzo(), oggetto.getVenditore());
                        }
                        request.setAttribute("Acquisto", "Oggetto Acquistato");
                        request.setAttribute("oggetto",oggetto);
                        //UtenteFactory.getInstance().getUtenti().add(cliente);
                        //Oggetti_VenditaFactory.getInstance().getListaOggettiinVendita().add(oggetto);
                            request.getRequestDispatcher("riepilogo_Acquisto.jsp").forward(request, response);
                    
            
            }
                    else{
                        request.setAttribute("Acquisto", "Saldo troppo Basso");
                        request.setAttribute("oggetto",oggetto);
                        request.getRequestDispatcher("riepilogo_Acquisto.jsp").forward(request, response);
                    }
        }
        else  
            request.getRequestDispatcher("cliente.html").forward(request, response);

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
            Logger.getLogger(Acquisto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Acquisto.class.getName()).log(Level.SEVERE, null, ex);
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
