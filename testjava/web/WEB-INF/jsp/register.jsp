<%-- 
    Document   : register
    Created on : 07-05-2016, 08:08:34 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../../include/head.jsp" />
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="register-logo">
                <a href="index.htm"></a>
            </div>
            <div class="register-box-body">
                <p class="login-box-msg">Registro Nuevo Usuario</p>
                <form action="index.htm" class="form">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Usuario" id="usuario" name="usuario" required="required">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" placeholder="Email" id="email" name="email" required="required">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Ingrese contraeña" id="pass" name="pass" required="required">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Repita la contraseña" id="pass2" name="pass2" required="required">
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox">
                                    Acepto los <a href="#">términos</a>
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat" id="registra">Registrarse</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
                <div class="social-auth-links text-center"></div>
                <a href="login.htm" class="text-center">Yo ya estoy registrado</a>
            </div>
            <!-- /.form-box -->
        </div>
        <!-- /.register-box -->
        <!-- jQuery 2.1.4 -->
        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <!-- Bootstrap 3.3.5 -->
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/plugins/pace/pace.js"></script>
        <!-- iCheck -->
        <script src="resources/plugins/iCheck/icheck.min.js"></script>
        <!-- SweetAlert -->
        <script src="resources/plugins/sweetalert/sweetalert.min.js"></script>
        <!-- page script -->
        <script src="resources/dist/js/scripts.js"></script>
    </body>
</html>