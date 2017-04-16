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
                                            <td>${building_site.address}, ${building_site.district}, ${building_site.region}</td>
                                            <td><span class="label label-${building_site.status==1?"success":"danger"}">${building_site.status==1?"Activa":"Inactiva"}</span></td>
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
                                <label for="name" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="name" id="name" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-sm-2 control-label">Dirección</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="address" id="address" placeholder="Dirección" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="region_id" class="col-sm-2 control-label">Región</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="region" id="region" disabled="disabled">
                                    <select name="region_id" id="region_id" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${regions}" var="region">
                                            <option value="${region.id}">${region.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="province_id" class="col-sm-2 control-label">Provincia</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="province" id="province" disabled="disabled">
                                    <select name="province_id" id="province_id" class="form-control" style="width: 100%;" required="required">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="district_id" class="col-sm-2 control-label">Comuna</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="district" id="district" disabled="disabled">
                                    <select name="district_id" id="district_id" class="form-control" style="width: 100%;" required="required">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-sm-2 control-label">Estado</label>
                                <div class="col-sm-10">
                                    <select name="status" id="status" class="form-control" style="width: 100%;" required="required">
                                        <option value="1">Activa</option>
                                        <option value="0">Inactiva</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="usuarios" data-url="./obras">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>