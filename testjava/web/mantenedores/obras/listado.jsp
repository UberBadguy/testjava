<%-- 
    Document   : listado
    Created on : 02-04-2017, 03:37:02 PM
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
            <h1>Mantenedor Obras</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Obras</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nueva</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Dirección</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listado}" var="building_site">
                                        <tr>
                                            <td>${building_site.name}</td>
                                            <td>${building_site.address}</td>
                                            <td><span class="label label-${building_site.status==1?"success":"danger"}">${building_site.status==1?"Activo":"Inactivo"}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${building_site.id}" data-url="./obras/update" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <c:if test="${building_site.status==1}"><a class="btn btn-primary btn-xs btnEliminar" data-id="${building_site.id}" data-url="./obras/update" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a></c:if>
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
                            <input class="form-control" name="id" id="id" type="hidden">
                            <div class="form-group">
                                <label for="usuario" class="col-sm-2 control-label">Usuario</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="login" id="login" placeholder="Usuario" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pass" class="col-sm-2 control-label">Contraseña</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="password" id="password" placeholder="Contraseña" type="password" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="email" id="email" placeholder="Email" type="email" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idResidente" class="col-sm-2 control-label">Empleado</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="name" id="name" disabled="disabled">
                                    <select name="employee_id" id="employee_id" class="form-control" style="width: 100%;">
                                        <c:forEach items="${employees}" var="employee">
                                            <option value="${employee.id}">${employee.name} ${employee.last_name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idPerfil" class="col-sm-2 control-label">Perfil</label>
                                <div class="col-sm-10">
                                    <select name="profile_id" id="profile_id" class="form-control" style="width: 100%;">
                                        <c:forEach items="${profiles}" var="profile">
                                            <option value="${profile.id}">${profile.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="estado" class="col-sm-2 control-label">Estado</label>
                                <div class="col-sm-10">
                                    <select name="status" id="status" class="form-control" style="width: 100%;" required="required">
                                        <option value="1">Activo</option>
                                        <option value="0">Inactivo</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="usuarios" data-url="./usuarios">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>