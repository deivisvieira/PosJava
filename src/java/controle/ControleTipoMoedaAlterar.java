/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoMoeda;
import persistencia.DAOTipoMoeda;

/**
 *
 * @author profoswaldo
 */
public class ControleTipoMoedaAlterar extends HttpServlet {

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

        try {
            daoTipoMoeda = new DAOTipoMoeda();
            tipoMoeda = new TipoMoeda();

            tipoMoeda.setId(Integer.parseInt(request.getParameter("txtId")));
            tipoMoeda.setNome(request.getParameter("txtNome"));
            tipoMoeda.setSimbolo(request.getParameter("txtSimbolo"));

            daoTipoMoeda.alterar(tipoMoeda);

            msg = "Alteração realizada com sucesso";

        } catch (Exception exception) {
            msg = "Erro na Alteração";
        } finally {
            request.setAttribute("mensagem", msg);
            view = request.getRequestDispatcher("pages/status.jsp");
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
