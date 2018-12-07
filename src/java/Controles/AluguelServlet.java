/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCliente;
import DAOs.DAOAluguel;
import Entidades.Cliente;
import Entidades.Aluguel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaque
 */
@WebServlet(name = "AluguelServlet", urlPatterns = {"/aluguel"})
public class AluguelServlet extends HttpServlet {

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
        int idAluguel;
        int clienteIdCliente;
        String dataAluguel="";
        String observacoes = "";
        DAOAluguel daoAluguel = new DAOAluguel();
        Aluguel produto = new Aluguel();
        try (PrintWriter out = response.getWriter()) {
            idAluguel = Integer.valueOf(request.getParameter("idAluguel"));
            produto.setIdAluguel(idAluguel);

            dataAluguel = request.getParameter("dataAluguel");
            produto.setDataAluguel(dataAluguel);

            observacoes = request.getParameter("observacoes");
            produto.setObservacoes(observacoes);

            DAOCliente daoCliente = new DAOCliente();
            Integer clienteId = Integer.valueOf(request.getParameter("clienteIdCliente"));
            Cliente cliente = daoCliente.listById(clienteId).get(0);
            produto.setClienteIdCliente(daoCliente.obter(clienteId));
            
            daoAluguel.inserir(produto);
            String resultadoAluguel = "";

            resultadoAluguel = listaAluguelsCadastrados();

            request.getSession().setAttribute("resultadoAluguel", resultadoAluguel);
            response.sendRedirect(request.getContextPath() + "/paginas/aluguel.jsp");
        }
    }
    
    protected String listaAluguelId(String idAluguel) {
        DAOAluguel daoAluguel = new DAOAluguel();
        String tabela = "";
        List<Aluguel> lista = daoAluguel.listById(0);
        for (Aluguel t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdAluguel() + "</td>"
                    + "<td> " + t.getDataAluguel() + "</td>"
                    + "<td> " + t.getObservacoes() + "</td>"
                    + "<td> " + t.getClienteIdCliente() + "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaAluguelsCadastrados() {
        DAOAluguel daoAluguel = new DAOAluguel();
        String tabela = "";
        List<Aluguel> lista = daoAluguel.list();
        for (Aluguel t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdAluguel() + "</td>"
                    + "<td> " + t.getDataAluguel() + "</td>"
                    + "<td> " + t.getObservacoes() + "</td>"
                    + "<td> " + t.getClienteIdCliente() + "</td>"
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
