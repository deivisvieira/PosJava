/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoMoeda;
import persistencia.DAOTipoMoeda;
import com.google.gson.Gson;

/**
 *
 * @author Deivis
 */
public class ControleTipoMoedaListar extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        try {
            daoTipoMoeda = new DAOTipoMoeda();
            tipoMoeda = new TipoMoeda();

            ArrayList<TipoMoeda> lista = daoTipoMoeda.listar();

            request.setAttribute("al", lista);
            
            Gson gson = new Gson();
            String jsonA =  gson.toJson(lista);
            out.println(jsonA);

        } catch (Exception exception) {
            tipoMsg = "danger";
            msg = exception.getMessage();
            view = request.getRequestDispatcher("/index.html");

        } finally {
            request.setAttribute("mensagem", msg);       
            request.setAttribute("tipoMsg", tipoMsg);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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
