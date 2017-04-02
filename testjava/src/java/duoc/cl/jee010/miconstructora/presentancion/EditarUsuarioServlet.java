/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentancion;

import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.negocio.UsuarioBO;
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
@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/editarUsuarioServlet","/editarUsuario"})
public class EditarUsuarioServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        int id=Integer.parseInt(request.getParameter("id_usuario"));
        UsuarioBO objUsuarioBO= new UsuarioBO();
        User objUsuario=objUsuarioBO.buscaUsuarioXcodigo(id);
        if(objUsuario!=null){
            sesion.setAttribute("usuarioBuscado", objUsuario);
            response.sendRedirect("AgregarUsuario.jsp");
        }else{
            sesion.setAttribute("error", "no se puede modificar el usuario");
            response.sendRedirect("MantenedorUsuario.jsp");
        }
      
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion=request.getSession();
        int id_usuario=Integer.parseInt(request.getParameter("hdnId_usuario"));
        String login=request.getParameter("txtLoginModifica");
        String pass=request.getParameter("txtPassModifica");        
        int id_perfil=Integer.parseInt(request.getParameter("ddlPerfilModifica"));
        User objUsuario= new User(id_usuario, login, pass, id_perfil);
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(objUsuarioBO.update(objUsuario)){
            sesion.removeAttribute("usuarioBuscado");
            sesion.setAttribute("exitoIngresoUsuario", "Usuario Actualizado Correctamente");
            response.sendRedirect("MantenedorUsuario.jsp");
        }else{
            sesion.setAttribute("error", "No se pudo updatear el usuario");
            response.sendRedirect("AgregarUsuario.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
