<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <jsp:useBean id="daoCliente" class="DAOs.DAOCliente"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/aluguel">
            
                   <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroModelo.jsp">Cadastro dos Modelos | </a>
                    <a href="cadastroCores.jsp">Cadastro das Cores | </a>
                    <a href="cadastroVeiculo.jsp">Cadastro das Veiculos | </a>
                    <a href="cadastroCliente.jsp">Cadastro dos Clientes | </a>
                    <a href="cadastroAluguelHasVeiculo.jsp">Cadastro ALuguel <--> Veiculo | </a>
  
                    <a href="cor.jsp">Lista das Cores | </a>
                    <a href="marca.jsp">Lista das Marcas  | </a>
                    <a href="modelo.jsp">Lista dos Modelos   | </a>
                    <a href="veiculo.jsp">Lista dos Veiculos  | </a>
                    <a href="cliente.jsp">Lista dos clientes  | </a>
                    <a href="aluguel.jsp">Lista dos alugueis  | </a>
                    <a href="aluguelHasVeiculo.jsp">Lista do Aluguel <--> Veiculo  | </a>
            <div>
                <div class="form-group">
                    <label>ID</label>
                    <% DAOs.DAOAluguel daoAluguel = new DAOs.DAOAluguel();%>
                    <input class="form-control" name="idAluguel" value="<%=daoAluguel.autoIdAluguel()%>" readonly="">
                </div>
                <div class="form-group">
                    <label>Data do aluguel</label>
                    <input class="form-control" name="dataAluguel">
                </div>
                <div class="form-group">
                    <label>Observacoes</label>
                    <input class="form-control" name="observacoes">
                </div>
                <div class="form-group">
                    <label>Selecione o id do Cliente</label>
                    <select class="form-control" name="clienteIdCliente">
                        <c:forEach var="cliente" items="${daoCliente.listInOrderId()}">                                                                                                   
                            <option value="${cliente.getIdCliente()}">${cliente.getIdCliente()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Cadastrar</button>
                <button type="reset" class="btn btn-default">Apagar campos</button>
            </div>
        </form>
    </body>
</html>
