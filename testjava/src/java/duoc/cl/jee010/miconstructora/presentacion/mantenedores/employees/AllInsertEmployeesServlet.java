/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.employees;

import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.negocio.BuildingSiteBO;
import duoc.cl.jee010.miconstructora.negocio.EmployeeBO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AllInsertEmployeesServlet", urlPatterns = {"/mantenedores/empleados/"})
public class AllInsertEmployeesServlet extends HttpServlet {

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
        BuildingSiteBO buildingSiteBO = new BuildingSiteBO();
        EmployeeBO employeeBO = new EmployeeBO();
        List<Employee> listado = employeeBO.getAllEmployees();
        List<BuildingSite> obras = buildingSiteBO.getAllBuildingSite();
        session.setAttribute("listado", listado);
        session.setAttribute("obras", obras);
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
        EmployeeBO employeeBO = new EmployeeBO();
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
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date birth_date = df.parse(request.getParameter("birth_date"));
            String gender = request.getParameter("gender");
            int building_site_id = Integer.valueOf(request.getParameter("building_site_id"));
            String payment_method = request.getParameter("payment_method");
            String account_number = request.getParameter("account_number");
            String bank = request.getParameter("bank");
            int value_per_hour = Integer.valueOf(request.getParameter("value_per_hour"));
            int status = Integer.valueOf(request.getParameter("status"));
            Employee employee = new Employee(id, rutAux, dv, name, last_name, birth_date, gender, building_site_id, payment_method, account_number, bank, value_per_hour, status);
            if (id > 0) {
                if (employeeBO.updateEmployee(employee))
                    json = "{\"response\":1}";
            } else {
                if (employeeBO.addEmployee(employee))
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
