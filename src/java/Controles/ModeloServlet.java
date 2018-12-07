/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOModelo;
import Entidades.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaque
 */
@WebServlet(name = "ModeloServlet", urlPatterns = {"/modelo"})
public class ModeloServlet extends HttpServlet {

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
        int idModelo = 0;
        String nomeModelo = "";
        String potenciaModelo = "";
        DAOModelo daoModelo = new DAOModelo();
        Modelo modelo = new Modelo();
        try (PrintWriter out = response.getWriter()) {
            idModelo = Integer.parseInt(request.getParameter("idModelo"));
            modelo.setIdModelo(daoModelo.autoIdModelo());

            nomeModelo = request.getParameter("nomeModelo");
            modelo.setNomeModelo(nomeModelo);
            
            potenciaModelo = request.getParameter("potenciaModelo");
            modelo.setPotenciaModelo(potenciaModelo);
            daoModelo.inserir(modelo);
            String resultadoModelo = "";

            resultadoModelo = listaModelosCadastrados();

            request.getSession().setAttribute("resultadoModelo", resultadoModelo);
            response.sendRedirect(request.getContextPath() + "/paginas/modelo.jsp");
        }
    }
    
    protected String listaModeloId(String idModelo) {
        DAOModelo daoModelo = new DAOModelo();
        String tabela = "";
        List<Modelo> lista = daoModelo.listById(0);
        for (Modelo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdModelo() + "</td>"
                    + "<td> " + t.getNomeModelo() + "</td>"
                    + "<td> " + t.getPotenciaModelo() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaModelosCadastrados() {
        DAOModelo daoModelo = new DAOModelo();
        String tabela = "";
        List<Modelo> lista = daoModelo.listInOrderNome();
        for (Modelo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdModelo() + "</td>"
                    + "<td> " + t.getNomeModelo() + "</td>"
                    + "<td> " + t.getPotenciaModelo() + "</td>"
                    + "</tr>";
        }
        return tabela;
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
