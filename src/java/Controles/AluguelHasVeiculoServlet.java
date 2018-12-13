/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOVeiculo;
import DAOs.DAOAluguel;
import DAOs.DAOModelo;
import DAOs.DAOAluguelHasVeiculo;
import Entidades.Veiculo;
import Entidades.Aluguel;
import Entidades.Modelo;
import Entidades.AluguelHasVeiculo;
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
@WebServlet(name = "AluguelHasVeiculoServlet", urlPatterns = {"/aluguelHasVeiculo"})
public class AluguelHasVeiculoServlet extends HttpServlet {

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
        int idAluguelHasVeiculo;
        int quantidadeDiasAluguelHasVeiculo;
        String valorDiaAluguelHasVeiculo;
        String dataAluguelHasVeiculo = "";
        String horaInicioAluguelHasVeiculo = "";
        String horaFimAluguelHasVeiculo = "";
        String AluguelAluguelHasVeiculo = "";
        String VeiculoAluguelHasVeiculo = "";
        DAOAluguelHasVeiculo daoAluguelHasVeiculo = new DAOAluguelHasVeiculo();
        AluguelHasVeiculo produto = new AluguelHasVeiculo();
        try (PrintWriter out = response.getWriter()) {
            idAluguelHasVeiculo = Integer.valueOf(request.getParameter("idAluguelHasVeiculo"));
            produto.setIdAluguelHasVeiculo(idAluguelHasVeiculo);
            
            quantidadeDiasAluguelHasVeiculo = Integer.valueOf(request.getParameter("quantidadeDiasAluguelHasVeiculo"));
            produto.setQuantidadeDias(quantidadeDiasAluguelHasVeiculo);

            valorDiaAluguelHasVeiculo = request.getParameter("valorDiaAluguelHasVeiculo");
            produto.setValorDia(valorDiaAluguelHasVeiculo);
            
            dataAluguelHasVeiculo = request.getParameter("dataAluguelHasVeiculo");
            produto.setData(dataAluguelHasVeiculo);
            
            horaInicioAluguelHasVeiculo = request.getParameter("horaInicioAluguelHasVeiculo");
            produto.setHoraInicio(horaInicioAluguelHasVeiculo);
            
            horaFimAluguelHasVeiculo = request.getParameter("horaFimAluguelHasVeiculo");
            produto.setHoraFim(horaFimAluguelHasVeiculo);

            DAOAluguel daoAluguel = new DAOAluguel();
            Integer AluguelIdAluguel = Integer.valueOf(request.getParameter("aluguelIdAluguel"));
            Aluguel aluguel = daoAluguel.listById(AluguelIdAluguel).get(0);
            produto.setAluguelIdAluguel(daoAluguel.obter(AluguelIdAluguel));

            DAOVeiculo daoVeiculo = new DAOVeiculo();
            Integer VeiculoId = Integer.valueOf(request.getParameter("veiculoIdVeiculo"));
            Veiculo Veiculo = daoVeiculo.listById(VeiculoId).get(0);
            produto.setVeiculoIdVeiculo(daoVeiculo.obter(VeiculoId));

          
            
            daoAluguelHasVeiculo.inserir(produto);
            String resultadoAluguelHasVeiculo = "";

            resultadoAluguelHasVeiculo = listaAluguelHasVeiculosCadastrados();

            request.getSession().setAttribute("resultadoAluguelHasVeiculo", resultadoAluguelHasVeiculo);
            response.sendRedirect(request.getContextPath() + "/paginas/aluguelHasVeiculo.jsp");
        }
    }
    
    protected String listaAluguelHasVeiculoId(String idAluguelHasVeiculo) {
        DAOAluguelHasVeiculo daoAluguelHasVeiculo = new DAOAluguelHasVeiculo();
        String tabela = "";
        List<AluguelHasVeiculo> lista = daoAluguelHasVeiculo.listById(0);
        for (AluguelHasVeiculo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdAluguelHasVeiculo() + "</td>"
                    + "<td> " + t.getQuantidadeDias()+ "</td>"
                    + "<td> " + t.getValorDia()+ "</td>"
                    + "<td> " + t.getData()+ "</td>"
                    + "<td> " + t.getHoraInicio()+ "</td>"
                    + "<td> " + t.getHoraFim()+ "</td>"
                    + "<td> " + t.getAluguelIdAluguel()+ "</td>"
                    + "<td> " + t.getVeiculoIdVeiculo()+ "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaAluguelHasVeiculosCadastrados() {
        DAOAluguelHasVeiculo daoAluguelHasVeiculo = new DAOAluguelHasVeiculo();
        String tabela = "";
        List<AluguelHasVeiculo> lista = daoAluguelHasVeiculo.list();
        for (AluguelHasVeiculo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdAluguelHasVeiculo() + "</td>"
                    + "<td> " + t.getQuantidadeDias()+ "</td>"
                    + "<td> " + t.getValorDia()+ "</td>"
                    + "<td> " + t.getData()+ "</td>"
                    + "<td> " + t.getHoraInicio()+ "</td>"
                    + "<td> " + t.getHoraFim()+ "</td>"
                    + "<td> " + t.getAluguelIdAluguel()+ "</td>"
                    + "<td> " + t.getVeiculoIdVeiculo()+ "</td>"
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
