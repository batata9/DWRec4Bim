<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <jsp:useBean id="daoCliente" class="DAOs.DAOCliente"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/cliente">
            
                    <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroModelo.jsp">Cadastro dos Modelos | </a>
                    <a href="cadastroCor.jsp">Cadastro das Cores | </a>
                    <a href="cadastroVeiculo.jsp">Cadastro dos Veiculos | </a>
                    <a href="cadastroAluguel.jsp">Cadastro dos Alugueis | </a>
                    <a href="cadastroAluguelHasVeiculo.jsp">Cadastro do Aluguel <--> Veiculo | </a>
  
                    <a href="cor.jsp">Lista das Cores | </a>
                    <a href="marca.jsp">Lista das Marcas  | </a>
                    <a href="modelo.jsp">Lista dos Modelos   | </a>
                    <a href="veiculo.jsp">Lista dos Veiculos  | </a>
                    <a href="cliente.jsp">Lista dos clientes  | </a>
                    <a href="aluguel.jsp">Lista dos alugueis  | </a>
                    <a href="aluguelHasVeiculo.jsp">Lista do ALuguel <--> Veiculo  | </a>
                    
                    </div></div>
            <div>
                <div class="form-group">
                    <label>ID</label>
                    <input class="form-control" name="idCliente" value="<%=daoCliente.autoIdCliente()%>" readonly="">
                </div>
                <div class="form-group">
                    <label>Nome</label>
                    <input class="form-control" name="nome">
                </div>
                <div class="form-group">
                    <label>Login</label>
                    <input class="form-control" name="login">
                </div>
                <div class="form-group">
                    <label>Senha</label>
                    <input class="form-control" name="senha">
                </div>
                <div class="form-group">
                    <label>Endereco</label>
                    <input class="form-control" name="endereco">
                </div>
                <div class="form-group">
                    <label>Bairro</label>
                    <input class="form-control" name="bairro">
                </div>
                <div class="form-group">
                    <label>Cidade</label>
                    <input class="form-control" name="cidade">
                </div>
                <div class="form-group">
                    <label>Cep</label>
                    <input class="form-control" name="cep">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Telefone</label>
                    <input class="form-control" name="telefone">
                </div>
                <div class="form-group">
                    <label>Celular</label>
                    <input class="form-control" name="celular">
                </div>
               
                
               
                <button type="submit" class="btn btn-default">Cadastrar</button>
                <button type="reset" class="btn btn-default">Apagar campos</button>
            </div>
        </form>
    </body>
</html>
