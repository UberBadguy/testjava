<%-- 
    Document   : Home
    Created on : 16-03-2017, 14:20:54
    Author     : amontess
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
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
                <div class="container theme-showcase">
                    <div class="jumbotron">
                        <h1>Sistema de Ejemplo</h1>                
                    </div>
                    <c:if test="${exito!=null}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${exito}"/>
                            <c:remove var="exitoIngresoUsuario"/>
                        </div>
                    </c:if>
                </div>
            </c:when>
            <c:otherwise>
                <c:redirect url="Login.jsp"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>



