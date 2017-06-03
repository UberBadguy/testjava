/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.paginas;


import duoc.cl.jee010.miconstructora.dto.PagesDTO;
import duoc.cl.jee010.miconstructora.persistencia.PageSessionBean;
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
@WebServlet(name = "AllInsertPagesServlet", urlPatterns = {"/mantenedores/paginas/"})
public class AllInsertPagesServlet extends HttpServlet {
    private LogSystem log = new LogSystem(this.getClass());
    private PagesDTO pages;
    
    @EJB
    private PageSessionBean pageSessionBean;
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
        PagesDTO parents = null;
        try {
            this.pages = pageSessionBean.allPages();
            parents = pageSessionBean.getAllAvailableParents();
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("pages", this.pages.getPages());
        session.setAttribute("parentPages", parents.getPages());
        view("/mantenedores/paginas/listado.jsp", request, response);
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
            String name = request.getParameter("name");
            String path = request.getParameter("path");
            String icon = request.getParameter("icon");
            int parent = 0;
            try {
                parent = Integer.valueOf(request.getParameter("parent"));
            } catch (Exception e) {
                parent = 0;
            }
            int status = Integer.valueOf(request.getParameter("status"));
            this.pages = new PagesDTO(
                    pageSessionBean.createBuildingSite(id, name, icon, path, parent, status)
            );
            if (id > 0) {
                if (pageSessionBean.updatePage(pages))
                    json = "{\"response\":1}";
            } else {
                if (pageSessionBean.addPage(pages))
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
