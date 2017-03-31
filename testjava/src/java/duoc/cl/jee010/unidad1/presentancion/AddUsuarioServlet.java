/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.presentancion;

import duoc.cl.jee010.unidad1.entidades.Usuario;
import duoc.cl.jee010.unidad1.negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amontess
 */
@WebServlet(name = "AddUsuarioServlet", urlPatterns = {"/addUsuarioServlet","/addUsuario"})
public class AddUsuarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion =request.getSession();
        String login=request.getParameter("txtLogin");
        String pass=request.getParameter("txtPass");
        int id_perfil=Integer.parseInt(request.getParameter("ddlPerfil"));
        if(!((id_perfil==0)||(pass==null)||(login==null))){
            Usuario objUsuario= new Usuario(login, pass, id_perfil);
            UsuarioBO objUsuarioBO= new UsuarioBO();
            if(objUsuarioBO.addUsuario(objUsuario)){
                sesion.setAttribute("exitoIngresoUsuario", "Usuario Correctamente Ingresado");
                response.sendRedirect("MantenedorUsuario.jsp");
            }else{
                sesion.setAttribute("error", "No se pudo ingresar la información.");
                response.sendRedirect("AgregarUsuario.jsp");
            }
                    
        }else{
            sesion.setAttribute("error1", "debe completar todos los campos");
            response.sendRedirect("AgregarUsuario.jsp");
        }               
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
