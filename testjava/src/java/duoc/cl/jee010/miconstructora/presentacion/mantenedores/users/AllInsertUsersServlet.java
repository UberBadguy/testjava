/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.users;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.negocio.EmployeeBO;
import duoc.cl.jee010.miconstructora.negocio.ProfileBO;
import duoc.cl.jee010.miconstructora.negocio.UserBO;
import duoc.cl.jee010.miconstructora.persistencia.UserDAO;
import java.io.IOException;
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
public class AllInsertUsersServlet extends HttpServlet {

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
        UserBO userBO = new UserBO();
        ProfileBO profileBO = new ProfileBO();
        EmployeeBO employeeBo = new EmployeeBO();
        List<User> listado = userBO.getAllUser();
        List<Profile> profiles = profileBO.getAllProfile();
        List<Employee> employees = employeeBo.getAllAvailableEmployees();
        session.setAttribute("profiles", profiles);
        session.setAttribute("employees", employees);
        session.setAttribute("listado", listado);
        view("/mantenedores/usuarios/listado.jsp", request, response);
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
        String json = "{\"response\":0}";
        UserDAO userDAO = new UserDAO();
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int employee_id = 0;
            try {
                employee_id = Integer.valueOf(request.getParameter("employee_id"));
            } catch (Exception e) {
                employee_id = 0;
            }
            int profile_id = Integer.valueOf(request.getParameter("profile_id"));
            int status = Integer.valueOf(request.getParameter("status"));
            User user = new User(id, login, password, email, profile_id, employee_id, status);
            if (id > 0) {
                if (userDAO.updateElement(user))
                    json = "{\"response\":1}";
            } else {
                if (userDAO.addElement(user))
                    json = "{\"response\":1}";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        session.setAttribute("json", json);
        view("/include/json.jsp", request, response);
    }
    
    private void view(String view, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher r;
        r = request.getRequestDispatcher(view);
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
