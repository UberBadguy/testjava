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
@WebServlet(name = "EliminaUsuarioServlet", urlPatterns = {"/eliminaUsuario"})
public class EliminaUsuarioServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        int id=Integer.parseInt(request.getParameter("id_usuario"));
        Usuario objUsuario= new Usuario();
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(objUsuarioBO.deleteUsuario(id)){
            sesion.setAttribute("exitoIngresoUsuario", "Usuario correctamente eliminado!");
            response.sendRedirect("MantenedorUsuario.jsp");
        }else{
            sesion.setAttribute("error", "no se pudo eliminar el usuario");
            response.sendRedirect("MantenedorUsuario.jsp");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
