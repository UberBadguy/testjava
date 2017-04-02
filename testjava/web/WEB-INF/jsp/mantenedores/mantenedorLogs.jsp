<%-- 
    Document   : mantenedorEstados
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:Master>
    <jsp:body>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Logs de Cambios</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Registros</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Usuario</th>
                                        <th>Tabla</th>
                                        <th>Registro</th>
                                        <th>Tipo Transacción</th>
                                        <th>Detalle</th>
                                        <th>Fecha</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${logs}" var="log">
                                        <tr>
                                            <td>${log.idUsuario}</td>
                                            <td>${log.tabla}</td>
                                            <td>${log.idRegistro}</td>
                                            <td>
                                                <span class="label label-${log.tipoTransaccion=="DELETE"?"danger":log.tipoTransaccion=="UPDATE"?"warning":log.tipoTransaccion=="INGRESO"?"success":"primary"}">${log.tipoTransaccion}</span>
                                            </td>
                                            <td>${log.detalle}</td>
                                            <td>${log.creado}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
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