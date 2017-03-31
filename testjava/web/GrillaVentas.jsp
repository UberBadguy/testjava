<%-- 
    Document   : GrillaVentas
    Created on : 29-03-2017, 10:31:14
    Author     : amontess
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grilla de ventas</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>       
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>                       
        <link href="css/theme.css" rel="stylesheet"/>
        <link href="css/signin.css.css" rel="stylesheet"/>        
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:choose>
            <c:when test="${usuarioConectado!=null}">
                <jsp:include page="Menu.jsp" flush="true"/>
                <jsp:include page="/cargaProductos" flush="true"/>
                <jsp:useBean id="producto" class="duoc.cl.jee010.unidad1.entidades.Producto" scope="page"/>
                <div class="container">
                    <div class="jumbotron">
                        <h1 class="text-center">Modulo de ventas</h1>
                        <div class="panel-body bg-info form-inline">
                            <form name="frmCarrito" method="post" action="./addCarrito">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <div class="dropdown">
                                            <div class="form-group">
                                                <label for="id_Producto" class="col-md-5  control-label">Producto</label>
                                                <div class="col-md-8">
                                                    <select class="form-control " id="id_Producto" name="ddlProducto">
                                                        <option value="0"><c:out value="--Seleccione producto--"/></option>
                                                        <c:forEach items="${listadoProductos}" var="producto">
                                                            <option value="${producto.id_producto}"><c:out value="${producto.nombre_producto}"/></option>
                                                        </c:forEach>
                                                    </select>                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <div class="col-md-1">
                                        <label for="txtCantidad" class="col-md-2 control-label ">cantidad</label>
                                        <div class="col-md-2">
                                            <input type="number" class="form-control" id="txtCantidad" name="txtCantidad" placeholder="Cantidad" required min="0">
                                        </div>
                                    </div>
                                </div>                                                                                                    
                                <div class="form-group">                                
                                    <div class="col-sm-offset-5 col-sm-3 ">
                                        <button type="submit" class="btn btn-success">Agregar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <c:if test="${listadoVentas!=null}">
                            <jsp:useBean id="productoVentaDTO" class="duoc.cl.jee010.unidad1.dto.ProductoVentaUsuarioDTO" scope="page"/>
                            <div class="panel-info bg-warning">
                                <h2 class="text-center">Productos Ingresados</h2>
                                <form class="form-inline" method="POST" action="">
                                    <div class="form-group text-left">
                                        <div class="col-sm-offset-1 col-sm-10">
                                            <label for="txtCodigoVenta" class="col-sm-6 control-label">Codigo Venta</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="txtCodigoVenta" name="txtCodigoVenta" value="<c:out value="${codigoVenta.toString()}"/>" disabled>
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="container panel-body panel-group" style="background-color: #ffffff" >
                                        <table class="table table-bordered table-striped">
                                            <thead class="bg-primary">
                                                <tr>
                                                    <td>Producto</td>
                                                    <td>Marca</td>                                                                                                        
                                                    <td>Precio unitario</td>
                                                    <td>Cantidad</td>
                                                    <td>SubTotal</td>  
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach items="${listadoDTOProductoVenta}" var="productoVentaDTO">
                                                    <tr>
                                                        <td><c:out value="${productoVentaDTO.nombre_producto}"/></td>
                                                        <td><c:out value="${productoVentaDTO.marca_producto}"/></td>
                                                        <td><c:out value="${productoVentaDTO.precio_producto}"/></td>
                                                        <td><c:out value="${productoVentaDTO.cantidad_venta}"/></td>
                                                        <td><c:out value="${productoVentaDTO.cantidad_venta*productoVentaDTO.precio_producto}"/></td>
                                                        <c:set var="total" value="${total+(productoVentaDTO.cantidad_venta*productoVentaDTO.precio_producto)}"/>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="row">
                                            <div class="col-sm-3 ">
                                                <input type="button" class="form-control btn-success " id="btnFinalizarCompra" name="btnFinalizarCompra" value="Realizar compra" onclick="window.location.href = './procesaCompra'">
                                            </div>
                                            <div class="col-sm-4 left">
                                                <input type="button" class="form-control btn-danger " id="btnLimpiarListado" name="btnLimpiarListado" value="LimpiarListado" onclick="window.location.href = './limpiaGrillaVentas'">
                                            </div>                                            
                                            <div class="col-sm-2 ">
                                                <label for="txtTotal" class="control-label text-right">Total Venta</label>
                                            </div>                                            
                                            <div class="col-sm-1">                                                
                                                <input type="text" class="form-control" id="txtTotal" name="txtTotalVenta" value="<c:out value="${total}"/>" disabled>
                                            </div>

                                        </div>
                                    </div>
                                </form>
                            </div>
                        </c:if>
                        <c:if test="${error!=null}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${error}"/>
                                <c:remove var="error"/>
                            </div>
                        </c:if>
                    </div>                    
                </div>
            </c:when>
            <c:otherwise>
                <c:redirect url="Login.jsp"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>

