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
@WebServlet(name = "ValidaIngresoServlet", urlPatterns = {"/validaIngresoServlet","/validaIngreso"})
public class ValidaIngresoServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        String login=request.getParameter("txtLogin");
        String pass=request.getParameter("txtPass");
        UsuarioBO objUsuarioBO= new UsuarioBO();
        User objUsuario=objUsuarioBO.validaUsuario(login, pass);
        if(objUsuario!=null){
            sesion.setAttribute("usuarioConectado", objUsuario);
            response.sendRedirect("Home.jsp");
        }else{
            sesion.setAttribute("error", "El Usuario no Existe");
            response.sendRedirect("Login.jsp");
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