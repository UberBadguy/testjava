<%-- 
    Document   : MantenedorUsuario
    Created on : 16-03-2017, 16:29:33
    Author     : amontess
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor de Usuarios</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>       
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>                       
        <link href="css/theme.css" rel="stylesheet"/>                       
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:choose>
            <c:when test="${usuarioConectado!=null}">
                <jsp:include page="Menu.jsp" flush="true"/>
                <jsp:include page="/getAllUsuario" flush="true"/>
                <div class="container">
                    <h1>Mantenedor Usuarios</h1>
                    <div class="jumbotron">
                        <div class="panel-body">
                            <jsp:useBean id="usuario" class="duoc.cl.jee010.unidad1.dto.UsuarioPerfilDTO" scope="page"/>
                            <table class="table table-bordered table-striped ">
                                <thead>
                                    <tr>
                                        <td>Nombre</td>
                                        <td>Perfil</td>
                                        <td>Editar</td>
                                        <td>Eliminar</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listadoUsuario}" var="usuario">
                                        <tr>
                                            <td><c:out value="${usuario.login_usuario}"/></td>
                                            <td><c:out value="${usuario.nombre_perfil}"/></td>
                                            <c:url var="editar" value="/editarUsuario">
                                                <c:param name="id_usuario" value="${usuario.id_usuario}"/>
                                            </c:url>
                                            <td><button type="button" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                            <c:url var="eliminar" value="/eliminaUsuario">
                                                <c:param name="id_usuario" value="${usuario.id_usuario}"/>
                                            </c:url>
                                            <td><button type="button" class="btn btn-xs btn-danger" onclick="window.location.href = '${eliminar}'">Eliminar</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="form-horizontal">
                                <form class="form-inline">
                                    <div class="form-group">
                                        <label class="sr-only" for="txtBuscaUsuario">Nombre Usuario</label>
                                        <input type="text" class="form-control" id="txtBuscaUsuario" name="txtBuscaUsuario" placeholder="Nombre Usuario">
                                    </div>                                    
                                    <button type="submit" class="btn btn-default">Buscar por usuario</button>
                                    <button type="button" class="btn btn-primary" onclick="window.location.href = 'AgregarUsuario.jsp'">Agregar</button>
                                </form>
                            </div>
                            <c:if test="${exitoIngresoUsuario!=null}">
                                <div class="alert alert-success" role="alert">
                                    <c:out value="${exitoIngresoUsuario}"/>
                                    <c:remove var="exitoIngresoUsuario"/>
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
                </div>
            </c:when>
            <c:otherwise>
                <c:redirect url="Login.jsp"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
