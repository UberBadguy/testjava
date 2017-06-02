/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.users;

import duoc.cl.jee010.miconstructora.dto.EmployeesDTO;
import duoc.cl.jee010.miconstructora.dto.ProfilesDTO;
import duoc.cl.jee010.miconstructora.dto.UsersDTO;
import duoc.cl.jee010.miconstructora.persistencia.EmployeeSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.PageSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.ProfileSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.UserSessionBean;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.io.IOException;
import javax.ejb.EJB;
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
@WebServlet(name = "AllInsertUsersServlet", urlPatterns = {"/mantenedores/usuarios/"})
public class AllInsertUsersServlet extends HttpServlet {
    private LogSystem log = new LogSystem(this.getClass());
    
    @EJB
    private UserSessionBean userSessionBean;
    private ProfileSessionBean profileSessionBean;
    private EmployeeSessionBean employeeSessionBean;
    private PageSessionBean pageSessionBean;
    private UsersDTO users;
    ProfilesDTO profile;
    EmployeesDTO employees;
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
        try {
            this.users = userSessionBean.allUsers();
            this.profile = profileSessionBean.allProfiles();
            this.employees = employeeSessionBean.allEmployees();
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("profiles", this.profile.getProfiles());
        session.setAttribute("employees", this.employees.getEmployees());
        session.setAttribute("listado", this.users.getUsers());
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
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int employee_id;
            try {
                employee_id = Integer.valueOf(request.getParameter("employee_id"));
            } catch (Exception e) {
                employee_id = 0;
            }
            int profile_id = Integer.valueOf(request.getParameter("profile_id"));
            this.employees = this.employeeSessionBean.getEmployee(employee_id);
            this.profile = this.profileSessionBean.getProfile(profile_id);
            int status = Integer.valueOf(request.getParameter("status"));
            this.users = new UsersDTO(
                    this.userSessionBean.createUser(id, login, password, email, status, employees, profile)
            );
            if (id > 0) {
                if (this.userSessionBean.updateUser(this.users))
                    json = "{\"response\":1}";
            } else {
                if (this.userSessionBean.addUser(this.users))
                    json = "{\"response\":1}";
            }
        } catch (Exception e) {
            this.log.getLogger().warn("Error al actualizar los datos. "+e.getMessage());
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
