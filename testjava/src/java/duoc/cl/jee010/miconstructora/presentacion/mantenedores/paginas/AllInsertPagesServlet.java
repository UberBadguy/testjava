/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.paginas;


import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.negocio.PageBO;
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
@WebServlet(name = "AllInsertPagesServlet", urlPatterns = {"/mantenedores/paginas/"})
public class AllInsertPagesServlet extends HttpServlet {
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
        PageBO pageBO = new PageBO();
        List<Page> list = null;
        List<Page> parentList = null;
        try {
            list = pageBO.getAllPages();
            parentList = pageBO.getAllAvailableParents();
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("pages", list);
        session.setAttribute("parentPages", parentList);
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
        PageBO pageBO = new PageBO();
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String login = request.getParameter("name");
            String password = request.getParameter("path");
            String email = request.getParameter("icon");
            int parent = 0;
            try {
                parent = Integer.valueOf(request.getParameter("parent"));
            } catch (Exception e) {
                parent = 0;
            }
            int status = Integer.valueOf(request.getParameter("status"));
            Page user = new Page(id, login, password, email, parent, status);
            if (id > 0) {
                if (pageBO.updatePage(user))
                    json = "{\"response\":1}";
            } else {
                if (pageBO.addPage(user))
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
