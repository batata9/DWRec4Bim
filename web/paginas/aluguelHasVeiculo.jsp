
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="dao" class="DAOs.DAOAluguelHasVeiculo"/>
<!DOCTYPE html>
<html lang="en">


    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" type="image/png" href="fenix.png"/>
        <title>Lista de Alugueis cadastrados aos Veiculos</title>

        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>

    <body>
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Aluguel <--> Veiculos Cadastrados
                </div>
              
                    <a href="cadastroMarca.jsp">Cadastro das Marcas | </a>
                    <a href="cadastroModelo.jsp">Cadastro dos Modelos | </a>
                    <a href="cadastroCor.jsp">Cadastro das Cores | </a>
                    <a href="cadastroVeiculo.jsp">Cadastro dos Veiculos | </a>
                    <a href="cadastroCliente.jsp">Cadastro dos Clientes | </a>
                    <a href="cadastroAluguel.jsp">Cadastro dos Alugueis | </a>
                    <a href="cadastroAluguelHasVeiculo.jsp">Cadastro Aluguel <--> Veiculo | </a>
  
                    <a href="cor.jsp">Lista das Cores | </a>
                    <a href="marca.jsp">Lista das Marcas  | </a>
                    <a href="modelo.jsp">Lista dos Modelos   | </a>
                    <a href="cliente.jsp">Lista dos clientes  | </a>
                    <a href="veiculo.jsp">Lista dos veiculos  | </a>
                    <a href="aluguel.jsp">Lista dos alugueis  | </a>
                    <a href="aluguelHasVeiculo.jsp">Lista do Aluguel <--> Veiculo  | </a>
                </div></div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row"><div class="col-sm-12">
                                <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
                                    <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Nome do produto" style="width: 170px;">Id</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Data</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Id Aluguel</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Id Veiculo</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Dias de aluguel</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Valor diário</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Hora de Início</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Hora de término</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="aluguelHasVeiculo" items="${dao.listInOrderId()}">
                                            <tr>
                                                <td>${aluguelHasVeiculo.getIdAluguelHasVeiculo()}</td>
                                                <td>${aluguelHasVeiculo.getData()}</td>
                                                <td>${aluguelHasVeiculo.getAluguelIdAluguel()}</td>
                                                <td>${aluguelHasVeiculo.getVeiculoIdVeiculo()}</td>
                                                <td>${aluguelHasVeiculo.getQuantidadeDias()}</td>
                                                <td>${aluguelHasVeiculo.getValorDia()}</td>
                                                <td>${aluguelHasVeiculo.getHoraInicio()}</td>
                                                <td>${aluguelHasVeiculo.getHoraFim()}</td>                                      
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table></div></div>
                        <!-- jstl -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>

            <!-- jQuery -->
            <script src="../vendor/jquery/jquery.min.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

            <!-- Metis Menu Plugin JavaScript -->
            <script src="../vendor/metisMenu/metisMenu.min.js"></script>

            <!-- DataTables JavaScript -->
            <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
            <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
            <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

            <!-- Custom Theme JavaScript -->
            <script src="../dist/js/sb-admin-2.js"></script>

            <!-- Page-Level Demo Scripts - Tables - Use for reference -->
            <script>
                $(document).ready(function () {
                    $('#dataTables-example').DataTable({
                        responsive: true
                    });
                });
            </script>
    </body>

</html>
