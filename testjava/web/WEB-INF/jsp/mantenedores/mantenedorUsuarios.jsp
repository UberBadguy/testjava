<%-- 
    Document   : mantenedorUsuarios
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
            <h1>Mantenedor Usuarios
                <small>Opciones avanzadas</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Usuarios</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Usuario</th>
                                        <th draggable="true">Email</th>
                                        <th>Estado</th>
                                        <th>Mantenedor</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <tr>
                                            <td>${usuario.idUsuario}</td>
                                            <td>${usuario.usuario}</td>
                                            <td>${usuario.email}</td>
                                            <td><span class="label label-${usuario.estado==1?"success":"danger"}">${usuario.nomEstado}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnVer" data-id="${usuario.idUsuario}" data-url="getUsuario.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${usuario.idUsuario}" data-url="getUsuario.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${usuario.idUsuario}" data-url="eliminaUsuario.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
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
                        <h4 class="modal-title">Detalles Usuario</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idUsuario" id="idUsuario" type="hidden">
                            <div class="form-group">
                                <label for="usuario" class="col-sm-2 control-label">Usuario</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="usuario" id="usuario" placeholder="Usuario" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pass" class="col-sm-2 control-label">Contraseña</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="pass" id="pass" placeholder="Contraseña" type="password" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="email" id="email" placeholder="Email" type="email" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idResidente" class="col-sm-2 control-label">Residente</label>
                                <div class="col-sm-10">
                                    <select name="idResidente" id="idResidente" class="form-control" style="width: 100%;">
                                        <c:forEach items="${residentes}" var="residente">
                                            <option value="${residente.idResidente}">${residente.persona.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idPerfil" class="col-sm-2 control-label">Perfil</label>
                                <div class="col-sm-10">
                                    <select name="idPerfil" id="idPerfil" class="form-control" style="width: 100%;">
                                        <c:forEach items="${perfiles}" var="perfil">
                                            <option value="${perfil.idPerfil}">${perfil.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idCondominio" class="col-sm-2 control-label">Condominio</label>
                                <div class="col-sm-10">
                                    <select name="idCondominio" id="idCondominio" class="form-control" style="width: 100%;">
                                        <c:forEach items="${condominios}" var="condominio">
                                            <option value="${condominio.idCondominio}">${condominio.nombre}</option>
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
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="usuarios" data-url="nuevoUsuario.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>

    </jsp:body>
</t:Master>