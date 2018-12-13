<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <jsp:useBean id="daoAluguel" class="DAOs.DAOAluguel"/>
    <jsp:useBean id="daoVeiculo" class="DAOs.DAOVeiculo"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/aluguelHasVeiculo">
                    
                    <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroModelo.jsp">Cadastro dos Modelos | </a>
                    <a href="cadastroCor.jsp">Cadastro das Cores | </a>
                    <a href="cadastroCliente.jsp">Cadastro dos Clientes | </a>
                    <a href="cadastroAluguel.jsp">Cadastro dos Alugueis | </a>
                    <a href="cadastroVeiculo.jsp">Cadastro dos Veiculos | </a>
  
                    <a href="cor.jsp">Lista das Cores | </a>
                    <a href="marca.jsp">Lista das Marcas  | </a>
                    <a href="modelo.jsp">Lista dos Modelos   | </a>
                    <a href="veiculo.jsp">Lista dos Veiculos  | </a>
                    <a href="cliente.jsp">Lista dos clientes  | </a>
                    <a href="aluguel.jsp">Lista dos alugueis  | </a>
                    <a href="aluguelHasVeiculo.jsp">Lista do Aluguel <--> Veiculo  | </a>
                    
                    </div></div>
            <div>
                <div class="form-group">
                    <label>ID</label>
                    <% DAOs.DAOAluguelHasVeiculo daoAluguelHasVeiculo = new DAOs.DAOAluguelHasVeiculo();%>
                    <input class="form-control" name="idAluguelHasVeiculo" value="<%=daoAluguelHasVeiculo.autoIdAluguelHasVeiculo()%>" readonly="">
                </div>
                <div class="form-group">
                    <label>Quantidade de Dias</label>
                    <input class="form-control" name="quantidadeDiasAluguelHasVeiculo">
                </div>
                <div class="form-group">
                    <label>Valor Dia</label>
                    <input class="form-control" name="valorDiaAluguelHasVeiculo">
                </div>
                 <div class="form-group">
                    <label>Data</label>
                    <input class="form-control" name="dataAluguelHasVeiculo">
                </div>
                 <div class="form-group">
                    <label>Hora Inicio</label>
                    <input class="form-control" name="horaInicioAluguelHasVeiculo">
                </div>
                 <div class="form-group">
                    <label>Hora Fim</label>
                    <input class="form-control" name="horaFimAluguelHasVeiculo">
                </div>
                <div class="form-group">
                    <label>Selecione o Aluguel</label>
                    <select class="form-control" name="aluguelIdAluguel">
                        <c:forEach var="aluguel" items="${daoAluguel.listInOrderId()}">                                                                                                   
                            <option value="${aluguel.getIdAluguel()}">${aluguel.getClienteIdCliente().getNome()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Selecione o Veiculo</label>
                    <select class="form-control" name="veiculoIdVeiculo">
                        <c:forEach var="veiculo" items="${daoVeiculo.listInOrderId()}">                                                                                                   
                            <option value="${veiculo.getIdVeiculo()}">${veiculo.getPlacaVeiculo()}</option>                                              
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Cadastrar</button>
                <button type="reset" class="btn btn-default">Apagar campos</button>
            </div>
        </form>
    </body>
</html>
