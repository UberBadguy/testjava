/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.presentancion;

import duoc.cl.jee010.unidad1.entidades.Perfil;
import duoc.cl.jee010.unidad1.negocio.PerfilBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "GetAllPerfilServlet", urlPatterns = {"/getAllPerfilServlet","/getAllPerfil"})
public class GetAllPerfilServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();        
        PerfilBO objPerfilBO= new PerfilBO();
        List<Perfil>listadoPerfiles= objPerfilBO.getAllPerfil();
        sesion.setAttribute("listadoPerfiles", listadoPerfiles);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
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
