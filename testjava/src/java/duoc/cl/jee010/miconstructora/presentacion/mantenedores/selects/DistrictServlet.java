/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.mantenedores.selects;

import duoc.cl.jee010.miconstructora.entidades.District;
import duoc.cl.jee010.miconstructora.negocio.DistrictBO;
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
@WebServlet(name = "DistrictServlet", urlPatterns = {"/mantenedores/comunas"})
public class DistrictServlet extends HttpServlet {

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
        String json = "{\"districts\":[";
        DistrictBO districtBO = new DistrictBO();
        try {
            int province_id = Integer.valueOf(request.getParameter("province_id"));
            List<District> districts = districtBO.listadoComunas(province_id);
            int size = districts.size();
            for (District district : districts) {
                if (--size == 0)
                    json += "{\"id\": " + district.getId() + ", \"text\": \"" + district.getName() + "\"}";
                else
                    json += "{\"id\": " + district.getId() + ", \"text\": \"" + district.getName() + "\"},";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        json += "]}";
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
