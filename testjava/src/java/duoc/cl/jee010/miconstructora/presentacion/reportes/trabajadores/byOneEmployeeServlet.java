/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.reportes.trabajadores;

import duoc.cl.jee010.miconstructora.dto.ReportEmployeeDTO;
import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.negocio.BuildingSiteBO;
import duoc.cl.jee010.miconstructora.negocio.EmployeeBO;
import duoc.cl.jee010.miconstructora.negocio.ProfileBO;
import duoc.cl.jee010.miconstructora.negocio.ReportBO;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
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
@WebServlet(name = "byOneEmployeeServlet", urlPatterns = {"/reportes/trabajadores/individual"})
public class byOneEmployeeServlet extends HttpServlet {
private LogSystem log = new LogSystem(this.getClass());
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
        EmployeeBO employeeBo = new EmployeeBO();
        String json = "";
        
        try {
            String rut = request.getParameter("rut");
            Employee employee = employeeBo.getEmployeeByRUT(Integer.valueOf(rut.substring(0, rut.length() - 2)));
            json = employee.toString();
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("json", json);
        view("/include/json.jsp", request, response);
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
