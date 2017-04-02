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
            <h1>Reserva Espacios Comunes
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#activity" data-toggle="tab">Espacios Comunes</a></li>
                            <li><a href="#timeline" data-toggle="tab">Reservas</a></li>
                            <li><a href="#settings" data-toggle="tab">Mantenimiento</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="activity">
                                <c:forEach items="${servicios}" var="servicio">           
                                    <div class="box box-default">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">${servicio.nombre}</h3>
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <div class="clearfix">
                                                <span class="pull-left">Ubicación Piso 25 - ${servicio.detalle}</span>
                                                <small class="pull-right">
                                                    <c:if test="${servicio.estado == 5}">0</c:if>
                                                    <c:if test="${servicio.estado == 1}">0</c:if>%
                                                </small>
                                            </div>
                                            <div class="progress active">
                                                <div class="progress-bar progress-bar-primary progress-bar-striped" role="progressbar" aria-valuenow="<c:if test="${servicio.estado == 5}">0</c:if><c:if test="${servicio.estado == 1}">0</c:if>" aria-valuemin="0" aria-valuemax="100" style="width: <c:if test="${servicio.estado == 5}">0</c:if><c:if test="${servicio.estado == 1}">0</c:if>%">
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="timeline">
                                <button type="submit" class="btn btn-primary pull-right" id="newItem">Nueva Reserva</button>
                                <table id="mantenedor" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Usuario</th>
                                            <th>Fecha</th>
                                            <th>Inicio</th>
                                            <th>Termino</th>
                                            <th>Valor</th>
                                            <th>Estado</th>
                                            <th>Observaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${reservasServicio}" var="reserva">
                                            <tr>
                                                <td>${reserva.idUsuario}</td>
                                                <td>${reserva.fecha}</td>
                                                <td><fmt:formatDate type="time" value="${reserva.horaInicio}"/></td>
                                                <td><fmt:formatDate type="time" value="${reserva.horaTermino}"/></td>
                                                <td>${reserva.valor}</td>
                                                <td><span class="label label-${reserva.estado==1?"success":"danger"}">${reserva.nomEstado}</span></td>
                                                <td>
                                                    <a class="btn btn-primary btn-xs btnAprobar" data-id="${reserva.idReserva}" data-url="apruebaReserva.htm" data-original-title="Aprobar" data-toggle="tooltip"><i class="fa fa-check"></i></a>
                                                    <a class="btn btn-primary btn-xs btnRechazar" data-id="${reserva.idReserva}" data-url="eliminaReserva.htm" data-original-title="Rechazar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot></tfoot>
                                </table>
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="settings">
                                
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
                        <h4 class="modal-title">Detalles Reserva</h4>
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
                                <label for="idServicio" class="col-sm-2 control-label">Servicio</label>
                                <div class="col-sm-10">
                                    <select name="idServicio" id="idServicio" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${servicios}" var="servicio">
                                            <option value="${servicio.idServicio}">${servicio.nombre}</option>
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