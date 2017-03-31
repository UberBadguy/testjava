<%-- 
    Document   : Login
    Created on : 16-03-2017, 12:15:02
    Author     : amontess
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>       
        <link href="css/signin.css" rel="stylesheet"/>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">            
            <form name="frmIngreso" class="form-signin" method="POST" action="./validaIngreso" >
                <h2 class="form-signin-heading text-center">Ingreso al Sistema</h2>
                <br/>
                <label for="txtLogin" class="">Login</label>

                <input type="text" id="txtLogin" name="txtLogin" class="form-control" placeholder="login" required autofocus>

                <label for="txtPass" class="sr-only">Password</label>
                <input type="password" id="txtPass" name="txtPass"  class="form-control" placeholder="Password" required>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Ingreso</button>
                <button class="btn btn-lg btn-link" type="button">Registrarse</button>                

            </form>
            <c:if test="${error!=null}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${error}"/>
                    <c:remove var="error"/>
                </div>
            </c:if>            
        </div>

    </body>
</html>
