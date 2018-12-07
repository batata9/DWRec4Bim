/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCor;
import DAOs.DAOMarca;
import DAOs.DAOModelo;
import DAOs.DAOVeiculo;
import Entidades.Cor;
import Entidades.Marca;
import Entidades.Modelo;
import Entidades.Veiculo;
import static Entidades.Veiculo_.placaVeiculo;
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
@WebServlet(name = "VeiculoServlet", urlPatterns = {"/veiculo"})
public class VeiculoServlet extends HttpServlet {

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
        int idVeiculo;
        double precoPorDiaVeiculo;
        String placaVeiculo = "";
        String marcaVeiculo = "";
        String corVeiculo = "";
        String modeloVeiculo = "";
        DAOVeiculo daoVeiculo = new DAOVeiculo();
        Veiculo produto = new Veiculo();
        try (PrintWriter out = response.getWriter()) {
            idVeiculo = Integer.valueOf(request.getParameter("idVeiculo"));
            produto.setIdVeiculo(idVeiculo);

            precoPorDiaVeiculo = Double.valueOf(request.getParameter("precoPorDiaVeiculo"));
            produto.setPrecoPorDia(precoPorDiaVeiculo);

            placaVeiculo = request.getParameter("placaVeiculo");
            produto.setPlacaVeiculo(placaVeiculo);

            DAOMarca daoMarca = new DAOMarca();
            Integer marcaId = Integer.valueOf(request.getParameter("marcaIdMarca"));
            Marca marca = daoMarca.listById(marcaId).get(0);
            produto.setMarcaIdMarca(daoMarca.obter(marcaId));

            DAOCor daoCor = new DAOCor();
            Integer corId = Integer.valueOf(request.getParameter("corIdCor"));
            Cor cor = daoCor.listById(corId).get(0);
            produto.setCorIdCor(daoCor.obter(corId));

            DAOModelo daoModelo = new DAOModelo();
            Integer modeloId = Integer.valueOf(request.getParameter("modeloIdModelo"));
            Modelo modelo = daoModelo.listById(modeloId).get(0);
            produto.setModeloIdModelo(daoModelo.obter(modeloId));
            
            daoVeiculo.inserir(produto);
            String resultadoVeiculo = "";

            resultadoVeiculo = listaVeiculosCadastrados();

            request.getSession().setAttribute("resultadoVeiculo", resultadoVeiculo);
            response.sendRedirect(request.getContextPath() + "/paginas/veiculo.jsp");
        }
    }
    
    protected String listaVeiculoId(String idVeiculo) {
        DAOVeiculo daoVeiculo = new DAOVeiculo();
        String tabela = "";
        List<Veiculo> lista = daoVeiculo.listById(0);
        for (Veiculo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdVeiculo() + "</td>"
                    + "<td> " + t.getPlacaVeiculo()+ "</td>"
                    + "<td> " + t.getPrecoPorDia() + "</td>"
                    + "<td> " + t.getMarcaIdMarca()+ "</td>"
                    + "<td> " + t.getModeloIdModelo()+ "</td>"
                    + "<td> " + t.getCorIdCor()+ "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaVeiculosCadastrados() {
        DAOVeiculo daoVeiculo = new DAOVeiculo();
        String tabela = "";
        List<Veiculo> lista = daoVeiculo.list();
        for (Veiculo t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getIdVeiculo() + "</td>"
                    + "<td> " + t.getPlacaVeiculo()+ "</td>"
                    + "<td> " + t.getPrecoPorDia() + "</td>"
                    + "<td> " + t.getMarcaIdMarca()+ "</td>"
                    + "<td> " + t.getModeloIdModelo()+ "</td>"
                    + "<td> " + t.getCorIdCor()+ "</td>"
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
