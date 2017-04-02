<%-- 
    Document   : mantenedorCondominios
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
            <h1>Mantenedor Condominios
                <small>Opciones avanzadas</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Condominios</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>nombre</th>
                                        <th>Dirección</th>
                                        <th>Represen.</th>
                                        <th>Creado</th>
                                        <th>Modificado</th>
                                        <th>Cuenta</th>
                                        <th>Estado</th>
                                        <th>Mantenedor</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${condominios}" var="condominio">
                                        <tr>
                                            <td>${condominio.idCondominio}</td>
                                            <td>${condominio.nombre}</td>
                                            <td>${condominio.direccion}, ${condominio.comuna}</td>
                                            <td>${condominio.representante}</td>
                                            <td>${condominio.creado}</td>
                                            <td>${condominio.modificado}</td>
                                            <td>${condominio.idCuentaCondominio}</td>
                                            <td><span class="label label-${condominio.estado==1?"success":"danger"}">${condominio.nomEstado}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnVer" data-id="${condominio.idCondominio}" data-url="getCondominio.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${condominio.idCondominio}" data-url="getCondominio.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${condominio.idCondominio}" data-url="eliminaCondominio.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
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
        <div class="modal" id="new">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Detalles Condominio</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idCondominio" id="idCondominio" type="hidden">
                            <div class="form-group">
                                <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="nombre" id="nombre" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="direccion" class="col-sm-2 control-label">Dirección</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="direccion" id="direccion" placeholder="Dirección" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idComuna" class="col-sm-2 control-label">Comuna</label>
                                <div class="col-sm-10">
                                    <select name="idComuna" id="idComuna" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${comunas}" var="comuna">
                                            <option value="${comuna.idComuna}">${comuna.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="representanteId" class="col-sm-2 control-label">Represen.</label>
                                <div class="col-sm-10">
                                    <select name="representanteId" id="representanteId" class="form-control" style="width: 100%;">
                                        <c:forEach items="${representantes}" var="representante">
                                            <option value="${representante.idRepresentante}">${representante.nombre}</option>
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
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="condominio" data-url="nuevoCondominio.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
        <!-- /.content -->
    </jsp:body>
</t:Master>