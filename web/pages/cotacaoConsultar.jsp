<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sistema de Visualização de Moedas</title>

        <!-- Bootstrap Core CSS -->
        <link href="/PosJava/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="/PosJava/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="/PosJava/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="/PosJava/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <jsp:include page="menu.jsp"/>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Cotação</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Consultar
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        <form action="/PosJava/controle.cotacao.consultar" method="POST">                                            
                                            <label for="tipomoeda">Selecione a Moeda:</label>
                                            <select class="form-control" id="cbId" name="cbId">
                                                <option value ="0">Todas</option>
                                            </select>                                                                             
                                            <label for="data">Digite a data:</label>
                                            <input class="form-control" type="text" name="txtData" value="" /><br/>
                                            <label for="valor">Digite o valor:</label>
                                            <input class="form-control" type="text" name="txtValor" value="" /><br/>
                                            <input class="btn btn-default" type="submit" value="Enviar" />
                                            <input class="btn btn-default" type="reset" value="Cancelar" />
                                        </form>
                                    </div>
                                </div>
                                <!-- /.row (nested) -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class ="panel panel-default">
                            <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
                                <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 153px;">Nome</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 186px;">Símbolo</th>
                                        <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 153px;">Valor</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 186px;">Data</th>
                                        <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 186px;"></th>
                                    </tr>
                                </thead>
                                <c:forEach var="item" items="${al}" varStatus="id">
                                    <tr class="#${id.count % 2 == 0 ? 'gradeA even' : 'gradeA odd' }" role="row">
                                        <td class="sorting_1">${item.tipoMoeda.nome}</td>
                                        <td>${item.tipoMoeda.simbolo}</td>
                                        <td class="sorting_1">${item.valor}</td>
                                        <td>${item.dataStringBr}</td>
                                        <td>
                                            <form action="/PosJava/controle.cotacao.excluir" method="POST">
                                                <input type="hidden" name="hdnId" value="${item.id}"/>
                                                <input type="submit" class="btn btn-danger" value="Excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="/PosJava/vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="/PosJava/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="/PosJava/vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="/PosJava/dist/js/sb-admin-2.js"></script>
        <script src="/PosJava/pages/Scripts/cotacao.js"></script>
        
    </body>

</html>
