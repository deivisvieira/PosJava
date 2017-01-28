<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema de Visualiza��o de Moedas</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

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

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Cont.Moeda v1.0</a>
            </div>
            <!-- /.navbar-header -->
            
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">                        
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Principal</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Tipo de Moeda<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="tipoMoedaIncluir.jsp">Incluir</a>
                                </li>
                                <li>
                                    <a href="tipoMoedaAlterar.jsp">Alterar</a>
                                </li>
                                <li>
                                    <a href="tipoMoedaConsultar.jsp">Consultar</a>
                                </li>
                                <li>
                                    <a href="tipoMoedaExcluir.jsp">Excluir</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                                                <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Cota��o<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="cotacaoIncluir.jsp">Incluir</a>
                                </li>
                                <li>
                                    <a href="cotacaoAlterar.jsp">Alterar</a>
                                </li>
                                <li>
                                    <a href="cotacaoConsultar.jsp">Consultar</a>
                                </li>
                                <li>
                                    <a href="cotacaoExcluir.jsp">Excluir</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tipo de Moeda</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Incluir
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="form-group">
                                    <form action="../controle.tipomoeda.incluir" method="POST">
                                        <label for="nome">Digite o nome:</label>
                                        <input class="form-control" type="text" name="txtNome" value="" /><br/>
                                        <label for="simbolo">Digite o s�mbolo:</label>
                                        <input class="form-control" type="text" name="txtSimbolo" value="" /><br/>
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
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
