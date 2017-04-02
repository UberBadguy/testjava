<%-- 
    Document   : mantenedorViviendas
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
            <h1>Mantenedor Viviendas
                <small>Opciones avanzadas</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Viviendas</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Número</th>
                                        <th>Piso</th>
                                        <th>Metros Cuadrados</th>
                                        <th>Sector</th>
                                        <th>Creado</th>
                                        <th>Modificado</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${viviendas}" var="vivienda">
                                        <tr>
                                            <td>${vivienda.numero}</td>
                                            <td>${vivienda.piso}</td>
                                            <td>${vivienda.metrosCuadrados}</td>
                                            <td>${vivienda.sector}</td>
                                            <td>${vivienda.creado}</td>
                                            <td>${vivienda.modificado}</td>
                                            <td><span class="label label-${vivienda.estado==1?"success":"danger"}">${vivienda.nomEstado}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnVer" data-id="${vivienda.idVivienda}" data-url="getVivienda.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${vivienda.idVivienda}" data-url="getVivienda.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${vivienda.idVivienda}" data-url="eliminaVivienda.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
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
                        <h4 class="modal-title">Detalles Vivienda</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idVivienda" id="idVivienda" type="hidden">
                            <div class="form-group">
                                <label for="numero" class="col-sm-2 control-label">Número</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="numero" id="numero" placeholder="Número" type="number" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="piso" class="col-sm-2 control-label">Piso</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="piso" id="piso" placeholder="Piso" type="number" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="metrosCuadrados" class="col-sm-2 control-label">M<sup>2</sup></label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="metrosCuadrados" id="metrosCuadrados" placeholder="Metros Cuadrados" type="number" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sector" class="col-sm-2 control-label">Sector</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="sector" id="sector" placeholder="Sector" type="text" required="required">
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
                                <label for="idTipoVivienda" class="col-sm-2 control-label">Tipo Vivienda</label>
                                <div class="col-sm-10">
                                    <select name="idTipoVivienda" id="idTipoVivienda" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${tiposVivienda}" var="tipoVivienda">
                                            <option value="${tipoVivienda.idTipoVivienda}">${tipoVivienda.nombre}</option>
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
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="vivienda" data-url="nuevaVivienda.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>

    </jsp:body>
</t:Master>