/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.building_sites;

import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.entidades.Region;
import duoc.cl.jee010.miconstructora.negocio.BuildingSiteBO;
import duoc.cl.jee010.miconstructora.negocio.RegionBO;
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
@WebServlet(name = "AllInsertBuildingSitesServlet", urlPatterns = {"/mantenedores/obras"})
public class AllInsertBuildingSitesServlet extends HttpServlet {
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
        BuildingSiteBO buildingSiteBO = new BuildingSiteBO();
        RegionBO regionBO = new RegionBO();
        List<Region> regions = null;
        List<BuildingSite> listado = null;
        try{
            regions = regionBO.listadoRegiones();
            listado = buildingSiteBO.getAllBuildingSite(); 
        }catch (Exception e){
            this.log.getLogger().warn("Fallo al solicitar la informacion. "+e.getMessage());
        }
        session.setAttribute("listado", listado);
        session.setAttribute("regions", regions);
        view("/mantenedores/obras/listado.jsp", request, response);
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
        BuildingSiteBO buildingSiteBO = new BuildingSiteBO();
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            int district_id = Integer.valueOf(request.getParameter("district_id"));
            int status = Integer.valueOf(request.getParameter("status"));
            BuildingSite buildingSite = new BuildingSite(id, name, address, district_id, status);
            if (id > 0) {
                if (buildingSiteBO.updateBuildingSite(buildingSite))
                    json = "{\"response\":1}";
            } else {
                if (buildingSiteBO.addBuildingSite(buildingSite))
                    json = "{\"response\":1}";
            }
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar la informacion. "+e.getMessage());
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
