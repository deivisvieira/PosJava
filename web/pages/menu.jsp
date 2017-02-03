<%-- 
    Document   : menu
    Created on : 28/01/2017, 15:14:03
    Author     : Deivis
--%>
<input type="hidden" name="hdnMsg" id="hdnMsg" value="${mensagem}">
<input type="hidden" name="hdnTipoMsg" id="hdnTipoMsg" value="${tipoMsg}">
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/PosJava/index.html">Cont.Moeda v1.0</a>
    </div>
    <!-- /.navbar-header -->

    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">                        
                <li>
                    <a href="/PosJava/index.html"><i class="fa fa-dashboard fa-fw"></i> Principal</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Tipo de Moeda<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapsed">
                        <li>
                            <a href="/PosJava/pages/tipoMoedaIncluir.jsp">Incluir</a>
                        </li>
                        <li>
                            <a href="/PosJava/pages/tipoMoedaConsultar.jsp">Consultar/Excluir</a>
                        </li>                                
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-money fa-fw"></i> Cotação<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapsed">
                        <li>
                            <a href="/PosJava/pages/cotacaoIncluir.jsp">Incluir</a>
                        </li>
                        <li>
                            <a href="/PosJava/pages/cotacaoConsultar.jsp">Consultar/Excluir</a>
                        </li>                                
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="sobre.jsp"><i class="fa fa-info-circle fa-fw"></i> Sobre</a>
                </li> 
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>
    <script src="/PosJava/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/PosJava/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/PosJava/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/PosJava/vendor/raphael/raphael.min.js"></script>
    <script src="/PosJava/vendor/morrisjs/morris.min.js"></script>    
    
    <!-- Custom Theme JavaScript -->
    <script src="/PosJava/dist/js/sb-admin-2.js"></script>
    <script src="/PosJava/js/bootstrap-notify.min.js"></script>
    <script src="/PosJava/pages/Scripts/main.js"></script>