<%-- 
    Document   : mantenedorPersonal
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
            <h1>Mantenedor Personal
                <small>Opciones avanzadas</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Personal</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Dirección</th>
                                        <th>Email</th>
                                        <th>Tipo</th>
                                        <th>Condominio</th>
                                        <th>Estado</th>
                                        <th>Mantenedor</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${personal}" var="persona">
                                        <tr>
                                            <td>${persona.rut}</td>
                                            <td>${persona.nombre} ${persona.apPaterno} ${persona.apMaterno}</td>
                                            <td>${persona.direccion}, ${persona.nomComuna}</td>
                                            <td>${persona.email}</td>
                                            <td>${persona.nomPersonal}</td>
                                            <td>${persona.nomCondominio}</td>
                                            <td><span class="label label-${persona.estado==1?"success":"danger"}">${persona.nomEstado}</span></td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnVer" data-id="${persona.idPersonal}" data-url="getPersonal.htm" data-original-title="Detalles" data-toggle="tooltip"><i class="fa fa-eye"></i></a>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${persona.idPersonal}" data-url="getPersonal.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${persona.idPersonal}" data-url="eliminaPersonal.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
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
                        <h4 class="modal-title">Detalles Personal</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="idPersonal" id="idPersonal" type="hidden">
                            <input class="form-control" name="idPersona" id="idPersona" type="hidden">
                            <div class="form-group">
                                <label for="rut" class="col-sm-2 control-label">Rut</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="rut" id="rut" placeholder="Rut" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="nombre" id="nombre" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apPaterno" class="col-sm-2 control-label">Apellido Paterno</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="apPaterno" id="apPaterno" placeholder="Apellido Paterno" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apMaterno" class="col-sm-2 control-label">Apellido Materno</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="apMaterno" id="apMaterno" placeholder="Apellido Materno" type="text" required="required">
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
                                <label for="email" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="email" id="email" placeholder="Email" type="email" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="tipo" class="col-sm-2 control-label">Tipo</label>
                                <div class="col-sm-10">
                                    <select name="tipo" id="tipo" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${tiposPersonal}" var="tipo">
                                            <option value="${tipo.idTipoPersonal}">${tipo.nombre}</option>
                                        </c:forEach>
                                    </select>
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
                                <label for="idEmpresaContratista" class="col-sm-2 control-label">Empresa Contratista</label>
                                <div class="col-sm-10">
                                    <select name="idEmpresaContratista" id="idEmpresaContratista" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${empresasContratista}" var="contratista">
                                            <option value="${contratista.idEmpresaContratista}">${contratista.nombre}</option>
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
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="servicios" data-url="nuevoPersonal.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>