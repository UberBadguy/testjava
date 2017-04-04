/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentancion.mantenedores.users;

import duoc.cl.jee010.miconstructora.dto.UserProfilePagesDTO;
import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.negocio.UserBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joe-Xidu
 */
@WebServlet(name = "AllInsertServlet", urlPatterns = {"/mantenedores/usuarios"})
public class AllInsertServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher r;
        UserBO userBO = new UserBO();
        List<User> listado = userBO.getAllUser();
        session.setAttribute("listado", listado);
        r = request.getRequestDispatcher("/mantenedores/usuarios/listado.jsp");
        r.forward(request, response);
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
        HttpSession session = request.getSession();
        RequestDispatcher r;
        String json = "{\"response\":0}";
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int employee_id = Integer.valueOf(request.getParameter("employee_id"));
            int profile_id = Integer.valueOf(request.getParameter("profile_id"));
            int status = Integer.valueOf(request.getParameter("status"));
            User user = new User(id, login, password, email, profile_id, employee_id, status);
            json = "{\"response\":1}";
        } catch (Exception e) {
            System.out.println(e);
        }
        session.setAttribute("json", json);
        r = request.getRequestDispatcher("/include/json.jsp");
        r.forward(request, response);
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
