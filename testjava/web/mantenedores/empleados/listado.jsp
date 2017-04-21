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
            <h1>Mantenedor Empleados</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Empleados</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Fecha Nacimiento</th>
                                        <th>Género</th>
                                        <th>Obra</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listado}" var="employee">
                                        <tr>
                                            <td>${employee.rut}-${employee.dv}</td>
                                            <td>${employee.name} ${employee.last_name}</td>
                                            <td>${employee.birth}</td>
                                            <td>${employee.gender}</td>
                                            <td>${employee.building_site_id}</td>
                                            <td><span class="label label-${employee.status==1?"success":"danger"}">${employee.status==1?"Activo":"Inactivo"}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${employee.id}" data-url="./update" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <c:if test="${employee.status==1}"><a class="btn btn-primary btn-xs btnEliminar" data-id="${employee.id}" data-url="./update" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a></c:if>
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
                                <label for="rut" class="col-sm-2 control-label">Rut</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="rut" id="rut" placeholder="Rut" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="name" id="name" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="last_name" class="col-sm-2 control-label">Apellido</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="last_name" id="last_name" placeholder="Apellido" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="birth" class="col-sm-2 control-label">Fecha Nacimiento</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="birth" id="birth_date" placeholder="Fecha Nacimiento" type="date" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gender" class="col-sm-2 control-label">Sexo</label>
                                <div class="col-sm-10">
                                    <select name="gender" id="gender" class="form-control" style="width: 100%;" required="required">
                                        <option value="M">M</option>
                                        <option value="F">F</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="building_site_id" class="col-sm-2 control-label">Obra</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="building_site_name" id="building_site_name" disabled="disabled">
                                    <select name="building_site_id" id="building_site_id" class="form-control" style="width: 100%;">
                                        <c:forEach items="${obras}" var="buildingSite">
                                            <option value="${buildingSite.id}">${buildingSite.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="payment_method" class="col-sm-2 control-label">Medio de Pago</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="payment_method" id="payment_method" placeholder="Medio de Pago" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="account_number" class="col-sm-2 control-label">Número de Cuenta</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="account_number" id="account_number" placeholder="Número de Cuenta" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="bank" class="col-sm-2 control-label">Banco</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="bank" id="bank" placeholder="Banco" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="value_per_hour" class="col-sm-2 control-label">Valor Hora</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="value_per_hour" id="value_per_hour" placeholder="Valor Hora" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-sm-2 control-label">Estado</label>
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
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="employees" data-url="./">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>