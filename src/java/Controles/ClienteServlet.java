/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCliente;
import Entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {

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
        String nome = "";
        int idCliente = 0;
        String login = "";
        String senha = "";
        String endereco = "";
        String bairro = "";
        String cidade = "";
        String cep = "";
        String email = "";
        String telefone = "";
        String celular = "";
        DAOCliente daoCliente = new DAOCliente();
        Cliente produto = new Cliente();
        try (PrintWriter out = response.getWriter()) {
            
            nome = request.getParameter("nome");
            produto.setNome(nome);
            
            login = request.getParameter("login");
            produto.setLogin(login);
            
            senha = request.getParameter("senha");
            produto.setSenha(senha);
            
            endereco= request.getParameter("endereco");
            produto.setEndereco(endereco);
            
            bairro = request.getParameter("bairro");
            produto.setBairro(bairro);
            
            cidade = request.getParameter("cidade");
            produto.setCidade(cidade);
            
            cep = request.getParameter("cep");
            produto.setCep(cep);
            
            email = request.getParameter("email");
            produto.setEmail(email);
            
            telefone = request.getParameter("telefone");
            produto.setTelefone(telefone);
            
            celular = request.getParameter("celular");
            produto.setCelular(celular);
            
            
            daoCliente.inserir(produto);
            String resultadoCliente = "";

            resultadoCliente = listaClientesCadastrados();

            request.getSession().setAttribute("resultadoCliente", resultadoCliente);
            response.sendRedirect(request.getContextPath() + "/paginas/cliente.jsp");
        }
    }
    
    protected String listaClienteId(String idCliente) {
        DAOCliente daoCliente = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = daoCliente.listById(0);
        for (Cliente t : lista) {
            tabela += "<tr>"
                    + "<td> " + t.getNome()+ "</td>"
                    + "<td> " + t.getLogin()+ "</td>"
                    + "<td> " + t.getSenha()+ "</td>"
                    + "<td> " + t.getEndereco()+ "</td>"
                    + "<td> " + t.getBairro()+ "</td>"
                    + "<td> " + t.getCidade()+ "</td>"
                    + "<td> " + t.getCep()+ "</td>"
                    + "<td> " + t.getTelefone()+ "</td>"
                    + "<td> " + t.getCelular()+ "</td>"
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaClientesCadastrados() {
        DAOCliente daoCliente = new DAOCliente();
        String tabela = "";
        List<Cliente> lista = daoCliente.list();
        for (Cliente t : lista) {
            tabela += "<tr>"
                     + "<td> " + t.getNome()+ "</td>"
                    + "<td> " + t.getLogin()+ "</td>"
                    + "<td> " + t.getSenha()+ "</td>"
                    + "<td> " + t.getEndereco()+ "</td>"
                    + "<td> " + t.getBairro()+ "</td>"
                    + "<td> " + t.getCidade()+ "</td>"
                    + "<td> " + t.getCep()+ "</td>"
                    + "<td> " + t.getTelefone()+ "</td>"
                    + "<td> " + t.getCelular()+ "</td>"
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
