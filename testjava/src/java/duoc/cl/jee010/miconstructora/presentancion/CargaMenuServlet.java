/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentancion;

import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.negocio.MenuBO;
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
@WebServlet(name = "CargaMenuServlet", urlPatterns = {"/cargaMenuServlet","/cargaMenu"})
public class CargaMenuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        MenuBO objMenuBO= new MenuBO();
        User objUsuarioConectado=(User)sesion.getAttribute("usuarioConectado");
        List<Page>listadoMenu=objMenuBO.listadoMenuPorUsuario(objUsuarioConectado.getProfile_id());
        sesion.setAttribute("listadoMenu", listadoMenu);        
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