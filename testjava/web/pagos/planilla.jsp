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
            <h1>Planilla de Pagos</h1>
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
                                        <th>Nombre Completo</th>
                                        <th>Perfil</th>
                                        <th>Horas Trabajadas</th>
                                        <th>Atrasos</th>
                                        <th>Valor Por Hora</th>
                                        <th>Pago total</th>
                                        <th>Forma de Pago</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data}" var="payment">
                                        <c:if test="${payment.rut!=null}">
                                            <tr>
                                                <td>${payment.rut}</td>
                                                <td>${payment.full_name}</td>
                                                <td>${payment.role}</td>
                                                <td>${payment.delayed_entry}</td>
                                                <td>${payment.worked_hours}</td>
                                                <td>${payment.value_per_hour}</td>
                                                <td>${payment.total_payment}</td>
                                                <td>${payment.payment_method}</td>
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
                              <h3 class="profile-username text-center data" id="name"></h3>
                              <h3 class="profile-username text-center data" id="last_name"></h3>

                              <p class="text-muted text-center data" id="building_site_name"></p>

                              <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                  <b>Fecha de Nacimiento</b> <a class="pull-right data" id="birth"></a>
                                </li>
                                <li class="list-group-item">
                                  <b>Sexo</b> <a class="pull-right data" id="gender"></a>
                                </li>
                                <li class="list-group-item">
                                  <b>RUT</b> <a class="pull-right data" id="rut"></a> - <a class="pull-right data" id="dv"></a>
                                </li>
                              </ul>

                            </div>
                            <!-- /.box-body -->
                          </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>