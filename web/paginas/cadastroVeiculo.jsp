<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <jsp:useBean id="daoCor" class="DAOs.DAOCor"/>
    <jsp:useBean id="daoMarca" class="DAOs.DAOMarca"/>
    <jsp:useBean id="daoModelo" class="DAOs.DAOModelo"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/veiculo">
                    
                    <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroModelo.jsp">Cadastro dos Modelos | </a>
                    <a href="cadastroCor.jsp">Cadastro das Cores | </a>
                    <a href="cadastroCliente.jsp">Cadastro dos Clientes | </a>
                    <a href="cadastroAluguel.jsp">Cadastro dos Alugueis | </a>
  
                    <a href="cor.jsp">Lista das Cores | </a>
                    <a href="marca.jsp">Lista das Marcas  | </a>
                    <a href="modelo.jsp">Lista dos Modelos   | </a>
                    <a href="veiculo.jsp">Lista dos Veiculos  | </a>
                    <a href="cliente.jsp">Lista dos clientes  | </a>
                    <a href="aluguel.jsp">Lista dos alugueis  | </a>
                    
                    </div></div>
            <div>
                <div class="form-group">
                    <label>ID</label>
                    <% DAOs.DAOVeiculo daoVeiculo = new DAOs.DAOVeiculo();%>
                    <input class="form-control" name="idVeiculo" value="<%=daoVeiculo.autoIdVeiculo()%>" readonly="">
                </div>
                <div class="form-group">
                    <label>Preco por dia</label>
                    <input class="form-control" name="precoPorDiaVeiculo">
                </div>
                <div class="form-group">
                    <label>Placa</label>
                    <input class="form-control" name="placaVeiculo">
                </div>
                <div class="form-group">
                    <label>Selecione a Marca</label>
                    <select class="form-control" name="marcaIdMarca">
                        <c:forEach var="marca" items="${daoMarca.listInOrderId()}">                                                                                                   
                            <option value="${marca.getIdMarca()}">${marca.getNome()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Selecione o Modelo</label>
                    <select class="form-control" name="modeloIdModelo">
                        <c:forEach var="modelo" items="${daoModelo.listInOrderId()}">                                                                                                   
                            <option value="${modelo.getIdModelo()}">${modelo.getNomeModelo()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Selecione a cor</label>
                    <select class="form-control" name="corIdCor">
                        <c:forEach var="cor" items="${daoCor.listInOrderId()}">                                                                                                   
                            <option value="${cor.getIdCor()}">${cor.getNome()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Cadastrar</button>
                <button type="reset" class="btn btn-default">Apagar campos</button>
            </div>
        </form>
    </body>
</html>
