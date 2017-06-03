/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.reportes.obra;

import duoc.cl.jee010.miconstructora.dto.BuildingSitesDTO;
import duoc.cl.jee010.miconstructora.dto.ProfilesDTO;
import duoc.cl.jee010.miconstructora.dto.ReportEmployeeDTO;
import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.persistencia.BuildingSiteSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.ProfileSessionBean;
import duoc.cl.jee010.miconstructora.persistencia.ReportsSessionBean;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "byEmployeeServlet", urlPatterns = {"/reportes/obra/empleados"})
public class byEmployeeServlet extends HttpServlet {
    private LogSystem log = new LogSystem(this.getClass());
    private ReportEmployeeDTO reportEmployeeDTO;
    private ProfilesDTO profilesDTO;
    private BuildingSitesDTO buildingSite;
    
    @EJB
    private BuildingSiteSessionBean buildingSiteSessionBean;
    private ReportsSessionBean reportsSessionBean;
    private ProfileSessionBean profileSessionBean;
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
        List<BuildingSite> buildingSites = null;
        try {
            this.profilesDTO = profileSessionBean.allProfiles();
            this.buildingSite = buildingSiteSessionBean.allBuildingSites();
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("profiles", this.profilesDTO.getProfiles());
        session.setAttribute("obras", this.buildingSite.getBuildingSites());
        view("/reportes/obra/empleados.jsp", request, response);
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
        List<ReportEmployeeDTO> listado = null;
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            listado = reportsSessionBean.buildingSiteXEmployee(id);
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("tabla", listado);
        view("/reportes/obra/tabla-empleados.jsp", request, response);
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
