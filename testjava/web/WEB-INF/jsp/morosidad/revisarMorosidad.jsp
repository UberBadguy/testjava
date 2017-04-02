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
            <h1>Revisar Morosidad
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#activity" data-toggle="tab">Morosos</a></li>
                            <li><a href="#settings" data-toggle="tab">Mantenimiento</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="activity">
                                <table id="mantenedor" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Usuario</th>
                                            <th>Fecha</th>
                                            <th>Atraso</th>
                                            <th>Valor</th>
                                            <th>Estado</th>
                                            <th>Observaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${morosos}" var="moroso">
                                            <tr>
                                                <td>${moroso.idPerfil}</td>
                                                <td>${moroso.nombre}</td>
                                                <td>${moroso.creado}</td>
                                                <td>${moroso.modificado}</td>
                                                <td><span class="label label-${moroso.estado==1?"success":"danger"}">${moroso.nomEstado}</span></td>
                                                <td>
                                                    <a class="btn btn-primary btn-xs btnVer" data-id="${moroso.idPerfil}" data-url="getPerfil.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                    <a class="btn btn-primary btn-xs btnEditar" data-id="${moroso.idPerfil}" data-url="getPerfil.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                    <a class="btn btn-primary btn-xs btnEliminar" data-id="${moroso.idPerfil}" data-url="eliminaPerfil.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot></tfoot>
                                </table>
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="settings">
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <i class="fa fa-bar-chart-o"></i>

                                        <h3 class="box-title">Morosidad Total</h3>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <div id="donut-chart" style="width: 500px;height: 300px;"></div>
                                    </div>
                            </div>
                            <!-- /.tab-pane -->
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
        <div class="modal" id="new">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Detalles Condominio</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idReserva" id="idReserva" type="hidden">
                            <div class="form-group">
                                <label for="fechas" class="col-sm-2 control-label">Fechas</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                        <input name="fechas" id="fechas"  type="text" class="form-control pull-right" required="required">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <div class="form-group">
                                <label for="usuarioId" class="col-sm-2 control-label">Usuario</label>
                                <div class="col-sm-10">
                                    <select name="usuarioId" id="usuarioId" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${usuarios}" var="usuario">
                                            <option value="${usuario.idUsuario}">${usuario.usuario}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="estado" class="col-sm-2 control-label">Estado</label>
                                <div class="col-sm-10">
                                    <select name="estado" id="estado" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${estados}" var="estado">
                                            <option value="${estado.idEstado}">${estado.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="observaciones" class="col-sm-2 control-label">Observaciones</label>
                                <div class="col-sm-10">
                                    <textarea name="observaciones" id="observaciones" placeholder="Observaciones" class="form-control" rows="3" placeholder="Observaciones..."></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="espaciosComunes" data-url="reservaEspaciosComunes.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>