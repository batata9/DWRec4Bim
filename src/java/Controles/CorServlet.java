/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCor;
import Entidades.Cor;
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
@WebServlet(name = "CorServlet", urlPatterns = {"/cor"})
public class CorServlet extends HttpServlet {

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
        int idCor = 0;
        String nomeCor = "";
        DAOCor daoCor = new DAOCor();
        Cor cor = new Cor();
        try (PrintWriter out = response.getWriter()) {
            idCor = Integer.parseInt(request.getParameter("idCor"));
            cor.setIdCor(daoCor.autoIdCor());

            nomeCor = request.getParameter("nomeCor");
            cor.setNome(nomeCor);
            daoCor.inserir(cor);
            String resultadoCor = "";

            resultadoCor = listaCorsCadastrados();

            request.getSession().setAttribute("resultadoCor", resultadoCor);
            response.sendRedirect(request.getContextPath() + "/paginas/cor.jsp");
        }
    }
    
    protected String listaCorId(String idCor) {
        DAOCor daoCor = new DAOCor();
        String tabela = "";
        List<Cor> lista = daoCor.listById(0);
        for (Cor t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdCor() + "</td>"
                    + "<td> " + t.getNome() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaCorsCadastrados() {
        DAOCor daoCor = new DAOCor();
        String tabela = "";
        List<Cor> lista = daoCor.listInOrderNome();
        for (Cor t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdCor() + "</td>"
                    + "<td> " + t.getNome() + "</td>"
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


