<%-- 
    Document   : historial
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:Master>
    <jsp:body>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Historial Gastos Comunes
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <i class="fa fa-bar-chart-o"></i>
                            <h3 class="box-title">Gastos Comunes</h3>
                            <div class="box-tools pull-right">
                                <button type="submit" class="btn btn-primary" data-url="generadorGastosComunes.htm" id="generaGastos">Generar gastos Comunes</button>
                                <select class="form-control" id="condominio">
                                    <c:forEach items="${condominios}" var="condominio">
                                        <option value="${condominio.idCondominio}">${condominio.nombre}</option>
                                    </c:forEach>
                                </select>
                                <select class="form-control">
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                </select>
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div id="flot-placeholder" style="height: 450px;"></div>     
                        </div>
                        <!-- /.box-body-->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </jsp:body>
</t:Master>