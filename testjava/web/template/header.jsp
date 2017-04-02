<%-- 
    Document   : header
    Created on : 06-05-2016, 02:36:54 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <div class="wrapper">
        <header class="main-header">
            <!-- Logo -->
            <a href="../../index2.html" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini">EAdmin</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b draggable="true">EspacioADMIN</b></span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                </a>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <!-- Notifications: style can be found in dropdown.less -->
                        <!-- Tasks: style can be found in dropdown.less -->
                        <!-- User Account: style can be found in dropdown.less -->
                        <!-- Control Sidebar Toggle Button -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                <span class="hidden-xs">${user.usuario}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header">
                                    <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                    <p>
                                        ${user.usuario}
                                        <small>${user.email}</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="row">
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Condominio</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Edificio</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">Vivienda</a>
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Perfil</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="logout.htm" class="btn btn-default btn-flat">Salir</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section style="height: auto;" class="sidebar">
                <!-- search form -->
                <form action="#" method="get" class="sidebar-form">
                    <div class="input-group">
                        <input name="q" class="form-control" placeholder="Buscar..." type="text">
                        <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">Navegación</li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-dashboard"></i>
                            <span>Perfil</span>
                            <small class="label pull-right bg-green">Condominio</small>
                        </a>
                    </li>
                    <c:if test="${user.nomPerfil!= 'Administrador'}">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-files-o"></i>
                                <span>Gastos comunes</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="detalleGastoComun.htm"><i class="fa fa-search"></i> Detalle</a></li>
                                <c:if test="${user.nomPerfil== 'Conserje'}">
                                    <li><a href="historialGastosComunes.htm"><i class="fa fa-th"></i> Historial</a></li>
                                </c:if>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${user.nomPerfil!= 'Administrador'}">
                        <li>
                            <a href="../widgets.html">
                                <i class="fa fa-th"></i>
                                <span>Residentes Morosos</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="morosidad.htm"><i class="fa fa-circle-o"></i> Revisar Morosidad</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${user.nomPerfil== 'Conserje'}">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-pie-chart"></i>
                                <span>Actividades condominio</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="espaciosComunes.htm"><i class="fa fa-circle-o"></i> Espacios Comunes</a></li>
                                <li><a href="estacionamientos.htm"><i class="fa fa-circle-o"></i> Estacionamientos</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${user.nomPerfil== 'Administrador'}">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>Sistema de pago</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
                                <li><a href="pages/layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed</a></li>
                                <li><a href="pages/layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed</a></li>
                                <li><a href="pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Collapsed Sidebar</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${user.nomPerfil!= 'Residente'}">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Mantenedores</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <c:if test="${user.nomPerfil== 'Administrador'}">
                                    <li><a href="mantenedorUsuarios.htm"><i class="fa fa-circle-o"></i> Usuarios</a></li>
                                    <li><a href="mantenedorPerfiles.htm"><i class="fa fa-circle-o"></i> Perfiles</a></li>
                                    <li><a href="mantenedorCondominios.htm"><i class="fa fa-circle-o"></i> Condominios</a></li>
                                    <li><a href="mantenedorTipoViviendas.htm"><i class="fa fa-circle-o"></i> Tipo Viviendas</a></li>
                                    <li><a href="mantenedorTipoCuentas.htm"><i class="fa fa-circle-o"></i> Tipo Cuentas</a></li>
                                    <li><a href="mantenedorEstados.htm"><i class="fa fa-circle-o"></i> Estados</a></li>
                                <li><a href="mantenedorLog.htm"><i class="fa fa-circle-o"></i> Log</a></li>
                                </c:if>
                                <c:if test="${user.nomPerfil== 'Conserje'}">
                                    <li><a href="mantenedorViviendas.htm"><i class="fa fa-circle-o"></i> Viviendas</a></li>
                                    <li><a href="mantenedorResidentes.htm"><i class="fa fa-circle-o"></i> Residentes</a></li>
                                    <li><a href="mantenedorProveedores.htm"><i class="fa fa-circle-o"></i> Proveedores</a></li>
                                    <li><a href="mantenedorServicios.htm"><i class="fa fa-circle-o"></i> Servicios</a></li>
                                    <li><a href="mantenedorPersonal.htm"><i class="fa fa-circle-o"></i> Personal</a></li>
                                </c:if>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>