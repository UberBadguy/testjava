/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.presentacion.asistencia;

import duoc.cl.jee010.miconstructora.entidades.Calendar;
import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.negocio.CalendarBO;
import duoc.cl.jee010.miconstructora.negocio.EmployeeBO;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.io.IOException;
import java.sql.Time;
import java.text.Format;
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
 * @author jose.becerra
 */
@WebServlet(name = "MarkingServlet", urlPatterns = {"/asistencia/marcaje"})
public class MarkingServlet extends HttpServlet {
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
        EmployeeBO employeeBO = new EmployeeBO();
        String date = null;
        List<Employee> listado = null;
        try {
            listado = employeeBO.getAllEmployeesCalendar();
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            date = formatter.format(new java.util.Date());
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al solicitar informacion. "+e.getMessage());
        }
        session.setAttribute("listado", listado);
        session.setAttribute("date", date);
        view("/asistencia/marcaje.jsp", request, response);
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
        String json = "{\"response\":0}";
        HttpSession session = request.getSession();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new java.util.Date());
        formatter = new SimpleDateFormat("HH:mm:ss");
        String time = formatter.format(new java.util.Date());
        CalendarBO calendarBO = new CalendarBO();
        try {
            int  rut = Integer.valueOf(request.getParameter("rut"));
            String type = request.getParameter("type");
            Calendar calendar = calendarBO.getCalendarByDate(date, rut);
            if (calendar != null) {
                switch (type) {
                    case "Entrada":
                        calendar.setStart(Time.valueOf(time));
                        break;
                    case "Salida":
                        calendar.setEnd(Time.valueOf(time));
                        break;
                }
                if (calendarBO.updateCalendar(calendar))
                    json = "{\"response\":1}";
            } else {
                calendar = new Calendar(
                        0,
                        (type.equalsIgnoreCase("Entrada")? Time.valueOf(time) : null),
                        (type.equalsIgnoreCase("Salida")? Time.valueOf(time) : null),
                        rut,
                        new java.util.Date(),
                        1
                );
                if (calendarBO.addCalendar(calendar))
                    json = "{\"response\":1}";
            }
        } catch (Exception e) {
            this.log.getLogger().warn("Fallo al actualizar informacion. "+e.getMessage());
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
