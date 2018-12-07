<%@page import="DAOs.DAOModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/modelo">
            
                    <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroCor.jsp">Cadastro das Cores | </a>
                    <a href="cadastroVeiculo.jsp">Cadastro dos Veiculos | </a>
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
                    <% DAOModelo daoModelo = new DAOModelo();%>
                    <input class="form-control" name="idModelo" value="<%=daoModelo.autoIdModelo()%>" readonly="">
                </div>
                <div class="form-group">
                    <label>Nome</label>
                    <input class="form-control" name="nomeModelo">
                </div>
                <div class="form-group">
                    <label>Potência</label>
                    <input class="form-control" name="potenciaModelo">
                </div>
                <button type="submit" class="btn btn-default">Cadastrar</button>
                <button type="reset" class="btn btn-default">Apagar campos</button>
            </div>
        </form>
    </body>
</html>
