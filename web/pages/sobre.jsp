<%-- 
    Document   : sobre
    Created on : 03/02/2017, 02:12:45
    Author     : Deivis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Sobre o Sistema</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab" aria-expanded="true">Overview</a>
                                </li>
                                <li class=""><a href="#profile" data-toggle="tab" aria-expanded="false">Criador</a>
                                </li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="home">
                                    <h4>Overview</h4>                                                                        
                                    <p>Esse sistema foi desenvolvido como trabalho da disciplina de Programação Orientada a Objetos, sem fins lucrativos. <strong>MIT License.</strong></p>                                            
                                    <p><strong>Ao professor Oswaldo:</strong></p>
                                    <p>O sistema foi feito para receber cotações de moedas baseadas no Real. Pode-se incluir novos tipos de moedas para em seguida inserir as cotações.</p>
                                    <p>Como todo sistema corporativo que se preze, os dados informados são apresentados de forma analítica para o usuário final. Em nosso caso, um resumo de últimas cotações e um gráfico comparativo.</p>
                                    <p>O intuito desse sistema foi apenas explorar um pouco do que foi lecionado em classe, integrados a conceitos que utilizo no meu dia a dia e adaptando ao mundo real.</p>
                                    <p>Obrigado pela paciência e peço desculpas pela falta de 'acabamento' em parte do sistema.</p>
                                    </br>
                                    <p><strong>Deivis.</strong></p>
                                </div>
                                <div class="tab-pane fade" id="profile">
                                    <div class="col-lg-12">
                                        <h4>Criador</h4>
                                        <div class="col-lg-2">                                            
                                            <script src="/PosJava/js/md5.js"></script>
                                            <script src="/PosJava/js/jquery.gravatar.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $('#imgDiv').attr('src', $.gravatar('deivisvieira@gmail.com', {secure: true, rating: 'pg', size: '120'}));
                                                });
                                            </script>
                                            <img src="" id="imgDiv" class="img-rounded"/>
                                        </div>

                                        <div class="col-lg-pull-6">
                                            <ul>
                                                <li>
                                                    <strong>Desenvolvedor:</strong> Deivis Queirolo Vieira                                                    
                                                </li>
                                                <li>
                                                    <strong>Cargo:</strong> Arquiteto de Sistemas
                                                </li>
                                                <li>
                                                    <strong>Idade:</strong> 29
                                                </li>
                                                <li>
                                                    <strong>Disciplina:</strong> Programação Orientada a Objetos
                                                </li>
                                                <li>
                                                    <strong>Observação: </strong> .NET é mais prático que Java, mas foi um bom desafio fazer esse mini projeto :-)
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
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


</body>
</html>
