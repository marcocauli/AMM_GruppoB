package packagecontroller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_CLEAN_PATH;
        try {
            Oggetti_VenditaFactory.getInstance().setConnectionString(dbConnection);
            Oggetti_VenditaFactory.getInstance().addToList();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Oggetti_VenditaFactory.getInstance().setConnectionString(dbConnection);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
                HttpSession session = request.getSession(false);
                if(session.getAttribute("loggedIn")==null)
                {
                   request.getRequestDispatcher("Unauthorized.jsp").forward(request, response); 
                }
                if((boolean)session.getAttribute("loggedIn")==true && session.getAttribute("Utente")=="cliente"){
                request.setAttribute("listaoggetti",Oggetti_VenditaFactory.getInstance().getListaOggettiinVendita());
                request.setAttribute("Saldo",UtenteFactory.getInstance().getClientebyId((Integer)session.getAttribute("id")).saldo.getSaldo());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
        if((boolean)session.getAttribute("loggedIn")==true && session.getAttribute("Utente")!="cliente"){
                    request.getRequestDispatcher("Unauthorized.jsp").forward(request, response);
             }
         if((boolean)session.getAttribute("loggedIn")==false && session.getAttribute("Utente")!="cliente"){
                    request.getRequestDispatcher("login.jsp").forward(request, response);
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
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
