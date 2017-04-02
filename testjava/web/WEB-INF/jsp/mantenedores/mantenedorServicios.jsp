<%-- 
    Document   : mantenedorProveedores
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:Master>
    <jsp:body>

       <section class="content-header">
            <h1>Mantenedor Servicios
                <small>Opciones avanzadas</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Servicios</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Detalle</th>
                                        <th>Valor Base</th>
                                        <th>Condominio</th>
                                        <th>Estado</th>
                                        <th>Mantenedor</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${servicios}" var="servicio">
                                        <tr>
                                            <td>${servicio.nombre}</td>
                                            <td>${servicio.detalle}</td>
                                            <td>${servicio.valorBase}</td>
                                            <td>${servicio.nomCondominio}</td>
                                            <td><span class="label label-${servicio.estado==1?"success":"danger"}">${servicio.nomEstado}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnVer" data-id="${servicio.idServicio}" data-url="getServicio.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${servicio.idServicio}" data-url="getServicio.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${servicio.idServicio}" data-url="eliminaServicio.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
                                            </td>
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
        <div class="modal" id="new">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Detalles Servicio</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idServicio" id="idServicio" type="hidden">
                            <div class="form-group">
                                <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="nombre" id="nombre" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="detalle" class="col-sm-2 control-label">Detalle</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="detalle" id="detalle" placeholder="Detalle" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="valorBase" class="col-sm-2 control-label">Valor Base</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="valorBase" id="valorBase" placeholder="Valor Base" type="number" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idCondominio" class="col-sm-2 control-label">Condominio</label>
                                <div class="col-sm-10">
                                    <select name="idCondominio" id="idCondominio" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${condominios}" var="condominio">
                                            <option value="${condominio.idCondominio}">${condominio.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="tipo" class="col-sm-2 control-label">Tipo</label>
                                <div class="col-sm-10">
                                    <select name="tipo" id="tipo" class="form-control" style="width: 100%;" required="required">
                                        <option value="1">Estacionamiento</option>
                                        <option value="2">Espacio Común</option>
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
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="servicios" data-url="nuevoServicio.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>