<%-- 
    Document   : Menu
    Created on : 16-03-2017, 15:07:41
    Author     : amontess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title></title>
    </head>
    <body>

        <jsp:include page="/cargaMenu" flush="true"/>
        <jsp:useBean id="usuarioConectado" class="duoc.cl.jee010.unidad1.entidades.Usuario" scope="session"/>
        <jsp:useBean id="objMenuPadre" class="duoc.cl.jee010.unidad1.entidades.Menu" scope="session"></jsp:useBean>
        <jsp:useBean id="objMenuHijo" class="duoc.cl.jee010.unidad1.entidades.Menu" scope="session"></jsp:useBean> 
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"  aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="Home.jsp">Usuario Conectado:<c:out value="${usuarioConectado.login_usuario}"/></a>                    
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <c:forEach items="${listadoMenu}" var="objMenuPadre">
                            <c:if test="${objMenuPadre.padre_menu==0}">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" ><c:out value="${objMenuPadre.nombre_menu}"></c:out> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                        <c:forEach items="${listadoMenu}" var="objMenuHijo"> 
                                            <c:if test="${objMenuHijo.id_menu!=0 && objMenuPadre.id_menu ==objMenuHijo.padre_menu}">                                                             
                                                <li><a href="<c:out value="${objMenuHijo.destino_menu}"/>"><c:out value="${objMenuHijo.nombre_menu}"></c:out></a></li>                       
                                                </c:if>
                                            </c:forEach>
                                    </ul>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>                    
                    <a class="navbar-brand btn-link navbar-right" href="./cerrarSesion">Salir</a>
                </div>                
            </div>                
        </nav>
    </body>
</html>
