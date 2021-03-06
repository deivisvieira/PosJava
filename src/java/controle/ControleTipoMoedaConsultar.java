/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoMoeda;
import persistencia.DAOTipoMoeda;

/**
 *
 * @author Deivis
 */
public class ControleTipoMoedaConsultar extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAOTipoMoeda daoTipoMoeda = null;
        TipoMoeda tipoMoeda = null;
        RequestDispatcher view = null;
        String msg = null;
        String tipoMsg = "success";

        try {
            daoTipoMoeda = new DAOTipoMoeda();
            tipoMoeda = new TipoMoeda();

            tipoMoeda.setNome(request.getParameter("txtNome"));
            tipoMoeda.setSimbolo(request.getParameter("txtSimbolo"));

            ArrayList<TipoMoeda> lista = daoTipoMoeda.consultar(tipoMoeda);

            request.setAttribute("al", lista);                                    
        } catch (Exception exception) {
            tipoMsg = "danger";
            msg = exception.getMessage();            

        } finally {
            view = request.getRequestDispatcher("/pages/tipoMoedaConsultar.jsp");
            request.setAttribute("mensagem", msg);
            request.setAttribute("tipoMsg", tipoMsg);
            view.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
