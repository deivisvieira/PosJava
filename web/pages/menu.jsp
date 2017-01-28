<%-- 
    Document   : menu
    Created on : 28/01/2017, 15:14:03
    Author     : Deivis
--%>

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
                                    <a href="tipoMoedaConsultar.jsp">Consultar</a>
                                </li>
                                <li>
                                    <a href="tipoMoedaExcluir.jsp">Excluir</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                                                <li>
                            <a href="#"><i class="fa fa-money fa-fw"></i> Cotação<span class="fa arrow"></span></a>
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