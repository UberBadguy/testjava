<%-- 
    Document   : historial
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:useBean id="paymentDay" class="java.util.Date" />
<jsp:setProperty name="paymentDay" property="time" value="${paymentDay.time + 1296000000}"/>

<t:Master>
    <jsp:body>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Detalle Gastos Comunes
            </h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <section class="invoice">
                            <!-- title row -->
                            <div class="row">
                                <div class="col-xs-12">
                                    <h2 class="page-header">
                                        <i class="fa fa-list-alt"></i> ${gastoComun.nomCondominio}
                                        <small class="pull-right">Fecha <fmt:formatDate pattern="dd/MM/yyyy" value='${now}' /></small>
                                    </h2>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- info row -->
                            <div class="row invoice-info">
                                <div class="col-sm-4 invoice-col">
                                    Condominio
                                    <address>
                                        <strong>${gastoComun.nomCondominio}</strong><br>
                                        Alameda 7098<br>
                                        Estación Central<br>
                                        Teléfono: (804) 123-5432<br>
                                        Correo: info@sigeco.cl
                                    </address>
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-4 invoice-col">
                                    Vivienda
                                    <address>
                                        <strong>${residente.persona.nombre} ${residente.persona.apPaterno}</strong><br>
                                        ${condominio.direccion}<br>
                                        ${vivienda.nomTipoVivienda} ${vivienda.numero}, ${condominio.comuna}<br>
                                        Teléfono: (555) 539-1037<br>
                                        Correo: ${user.email}
                                    </address>
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-4 invoice-col">
                                    <b>Código GC-007612</b><br>
                                    <br>
                                    <b>Rut:</b> ${residente.persona.rut}<br>
                                    <b>Pagar hasta:</b> <fmt:formatDate pattern="dd/MM/yyyy" value='${paymentDay}' /><br>
                                    <b>Cuenta:</b> 968-34567
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <!-- Table row -->
                            <div class="row">
                                <div class="col-xs-12 table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Item</th>
                                                <th>Código #</th>
                                                <th>Description</th>
                                                <th>Subtotal</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Sueldo</td>
                                                <td>6234234</td>
                                                <td>Pedrito Perez</td>
                                                <td>$640.000</td>
                                            </tr>
                                            <tr>
                                                <td>Cuenta Agua</td>
                                                <td>612312</td>
                                                <td>Aguas Andinas</td>
                                                <td>$880.600</td>
                                            </tr>
                                            <tr>
                                                <td>Cuenta Luz</td>
                                                <td>734534</td>
                                                <td>Chilectra</td>
                                                <td>$1.000.070</td>
                                            </tr>
                                            <tr>
                                                <td>Agua Caliente</td>
                                                <td>62326</td>
                                                <td>Cantera</td>
                                                <td>$1.200.979</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <div class="row">
                                <!-- accepted payments column -->
                                <div class="col-xs-6">
                                    <p class="lead">Medios de Pago:</p>
                                    <img src="resources/dist/img/credit/visa.png" alt="Visa">
                                    <img src="resources/dist/img/credit/mastercard.png" alt="Mastercard">
                                    <img src="resources/dist/img/credit/american-express.png" alt="American Express">
                                    <img src="resources/dist/img/credit/paypal2.png" alt="Paypal">

                                    <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                                        Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg
                                        dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra.
                                    </p>
                                </div>
                                <!-- /.col -->
                                <div class="col-xs-6">
                                    <p class="lead">Pagar hasta <fmt:formatDate pattern="dd/MM/yyyy" value='${paymentDay}' /></p>

                                    <div class="table-responsive">
                                        <table class="table">
                                            <tr>
                                                <th style="width:50%">Subtotal:</th>
                                                <td>$ 3.721.649</td>
                                            </tr>
                                            <tr>
                                                <th>Fondo de Reserva (5%):</th>
                                                <td>$ 186.082</td>
                                            </tr>
                                            <tr>
                                                <th>Prorrateo (0.0097%):</th>
                                                <td>$ 37.905</td>
                                            </tr>
                                            <tr>
                                                <th>Total:</th>
                                                <td>$ 3.907.731</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </section>
                        <div class="box box-footer">
                            <!-- this row will not appear when printing -->
                            <div class="row no-print">
                                <div class="col-xs-12">
                                    <a href="invoice-print.html" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> Imprimir</a>
                                    <button type="button" class="btn btn-primary pull-right" style="margin-right: 5px;">
                                        <i class="fa fa-download"></i> Generar PDF
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body-->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </jsp:body>
</t:Master>