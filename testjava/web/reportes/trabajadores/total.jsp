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
            <h1>Reporte Trabajadores</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Perfil</th>
                                        <th>Nombre de Obra</th>
                                        <th>Dias Trabajados</th>
                                        <th>Horas Trabajadas</th>
                                        <th>Atrasos</th>
                                        <th>Detalles</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tabla}" var="employeeDTO">
                                        <c:if test="${employeeDTO.rut!=null}">
                                            <tr>
                                                <td>${employeeDTO.rut}</td>
                                                <td>${employeeDTO.full_name}</td>
                                                <td>${employeeDTO.role}</td>
                                                <td>${employeeDTO.building_site_name}</td>
                                                <td>${employeeDTO.worked_days}</td>
                                                <td>${employeeDTO.worked_hours}</td>
                                                <td>${employeeDTO.delayed_entry}</td>
                                                <td>
                                                    <a class="btn btn-primary btn-xs btnDetalles" data-id="${usuario.id}" data-url="./individual" data-rut="${employeeDTO.rut}" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-user"></i></a>
                                                </td>
                                            </tr>
                                        </c:if>
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
                        <div class="box box-primary">
                            <div class="box-body box-profile" id="details">
                              <img class="profile-user-img img-responsive img-circle" src="../../dist/img/user4-128x128.jpg" alt="User profile picture">

                              <h3 class="profile-username text-center data" id="name"></h3>
                              <h3 class="profile-username text-center data" id="last_name"></h3>

                              <p class="text-muted text-center data" id="profile"></p>

                              <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                  <b>Followers</b> <a class="pull-right data"></a>
                                </li>
                                <li class="list-group-item">
                                  <b>Following</b> <a class="pull-right data"></a>
                                </li>
                                <li class="list-group-item">
                                  <b>Friends</b> <a class="pull-right data"></a>
                                </li>
                              </ul>

                              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
                            </div>
                            <!-- /.box-body -->
                          </div>
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