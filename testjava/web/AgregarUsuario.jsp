<%-- 
    Document   : AgregarUsuario
    Created on : 16-03-2017, 18:22:06
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
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>        
        <c:choose>
            <c:when test="${usuarioConectado!=null}">
                <jsp:useBean id="perfil" class="duoc.cl.jee010.unidad1.entidades.Perfil" scope="page"/>
                <jsp:include page="Menu.jsp" flush="true"/>
                <jsp:include page="/getAllPerfil" flush="true" />
                <c:choose>
                    <c:when test="${usuarioBuscado==null}">
                        <div class="container">
                            <div class="jumbotron">
                                <h1 class="text-center">Mantenedor Usuarios</h1>
                                <div class="panel-body bg-info">
                                    <form class="form-horizontal" method="POST" action="./addUsuario">
                                        <div class="form-group text-left">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <label for="txtLogin" class="col-sm-1 control-label">Login</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="txtLogin" name="txtLogin" placeholder="Login" required  maxlength="10">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <label for="txtPass" class="col-sm-1 control-label">Password</label>
                                                <div class="col-sm-6">
                                                    <input type="password" class="form-control" id="txtPass" name="txtPass" placeholder="Password" required maxlength="10">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <div class="dropdown">
                                                    <div class="form-group">
                                                        <label for="id_perfil" class="col-sm-1  control-label">Perfil</label>
                                                        <div class="col-sm-6">
                                                            <select class="form-control " id="id_perfil" name="ddlPerfil">
                                                                <option value="0"><c:out value="--Seleccione perfil--"/></option>
                                                                <c:forEach items="${listadoPerfiles}" var="perfil">
                                                                    <option value="${perfil.id_perfil}"><c:out value="${perfil.nombre_perfil}"/></option>
                                                                </c:forEach>
                                                            </select>                    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-5 ">
                                                <button type="submit" class="btn btn-default center-block">Guardar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <c:if test="${error!=null}">
                                    <div class="alert alert-danger" role="alert">
                                        <c:out value="${error}"/>
                                        <c:remove var="error"/>
                                    </div>
                                </c:if>
                                <c:if test="${error1!=null}">
                                    <div class="alert alert-danger" role="alert">
                                        <c:out value="${error1}"/>
                                        <c:remove var="error"/>
                                    </div>
                                </c:if>  
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="container">                            
                            <div class="jumbotron">
                                <h1 class="text-center">Modificar Usuario</h1>
                                <div class="panel-body bg-info">
                                    <form class="form-horizontal" method="POST" action="./editarUsuario">
                                        <input type="hidden" name="hdnId_usuario" value="${usuarioBuscado.getId_usuario()}"/> 
                                        <div class="form-group text-left">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <label for="txtLoginModifica" class="col-sm-1 control-label">Login</label>                                                
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" id="txtLoginModifica" name="txtLoginModifica" 
                                                           value="<c:out value="${usuarioBuscado.getLogin_usuario()}"/> " placeholder="Login" required maxlength="10">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <label for="txtPassModifica" class="col-sm-1 control-label">Password</label>
                                                <div class="col-sm-6">
                                                    <input type="password" class="form-control" id="txtPassModifica" name="txtPassModifica" placeholder="Password" required maxlength="10">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <div class="dropdown">
                                                    <div class="form-group">
                                                        <label for="id_ddlPerfilModifica" class="col-sm-1  control-label">Perfil</label>
                                                        <div class="col-sm-6">
                                                            <select class="form-control " id="id_ddlPerfilModifica" name="ddlPerfilModifica">
                                                                <option value="0"><c:out value="--Seleccione perfil--"/></option>
                                                                <c:forEach items="${listadoPerfiles}" var="perfil">
                                                                    <c:if test="${usuarioBuscado.getId_perfil()==perfil.id_perfil}">
                                                                        <option value="${perfil.id_perfil}" selected><c:out value="${perfil.nombre_perfil}"/></option>
                                                                    </c:if>
                                                                    <c:if test="${usuarioBuscado.getId_perfil()!=perfil.id_perfil}">
                                                                        <option value="${perfil.id_perfil}"><c:out value="${perfil.nombre_perfil}"/></option>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </select>
                                                                
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-5 ">
                                                <button type="submit" class="btn btn-default center-block">Guardar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <c:if test="${error!=null}">
                                    <div class="alert alert-danger" role="alert">
                                        <c:out value="${error}"/>
                                        <c:remove var="error"/>
                                    </div>
                                </c:if>
                                <c:if test="${error1!=null}">
                                    <div class="alert alert-danger" role="alert">
                                        <c:out value="${error1}"/>
                                        <c:remove var="error"/>
                                    </div>
                                </c:if>  
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:redirect url="Login.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </body>
</html>
