/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.employees;

import duoc.cl.jee010.miconstructora.dto.BuildingSitesDTO;
import duoc.cl.jee010.miconstructora.dto.EmployeesDTO;
import duoc.cl.jee010.miconstructora.persistencia.BuildingSiteSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.EmployeeSessionBean;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AllInsertEmployeesServlet", urlPatterns = {"/mantenedores/empleados/"})
public class AllInsertEmployeesServlet extends HttpServlet {
    private LogSystem log = new LogSystem(this.getClass());
    private EmployeesDTO employees;
    private BuildingSitesDTO buildingSites;
    
    @EJB
    private BuildingSiteSessionBean buildingSiteSessionBean;
    private EmployeeSessionBean employeeSessionBean;
    
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
        this.employees = new EmployeesDTO();
        this.buildingSites = new BuildingSitesDTO();
        try{
            this.employees = this.employeeSessionBean.allEmployees();
            this.buildingSites = this.buildingSiteSessionBean.allBuildingSites();
        }catch (Exception e){
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("listado", this.employees.getEmployees());
        session.setAttribute("obras", this.buildingSites.getBuildingSites());
        view("/mantenedores/empleados/listado.jsp", request, response);
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
            String rut = request.getParameter("rut");
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            String dv = String.valueOf(rut.charAt(rut.length() - 1));
            String name = request.getParameter("name");
            String last_name = request.getParameter("last_name");
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date birth_date = df.parse(request.getParameter("birth"));
            String gender = request.getParameter("gender");
            int building_site_id;
            try {
                building_site_id = Integer.valueOf(request.getParameter("building_site_id"));
            } catch (Exception e) {
                building_site_id = 0;
            }
            this.buildingSites = buildingSiteSessionBean.getBuildingSite(building_site_id);
            String payment_method = request.getParameter("payment_method");
            int account_number = Integer.valueOf(request.getParameter("account_number"));
            String bank = request.getParameter("bank");
            int value_per_hour = Integer.valueOf(request.getParameter("value_per_hour"));
            int status = Integer.valueOf(request.getParameter("status"));
            this.employees = new EmployeesDTO(
                    employeeSessionBean.createEmployee(id, rutAux, dv, name, last_name, birth_date, gender, this.buildingSites, payment_method, account_number, bank, value_per_hour, status)
            );
            if (id > 0) {
                if (this.employeeSessionBean.updateEmployee(this.employees))
                    json = "{\"response\":1}";
            } else {
                if (this.employeeSessionBean.addEmployee(this.employees))
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
