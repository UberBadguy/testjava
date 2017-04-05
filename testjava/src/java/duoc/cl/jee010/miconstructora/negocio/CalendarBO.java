/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Calendar;
import duoc.cl.jee010.miconstructora.persistencia.CalendarDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class CalendarBO {
    
    private final CalendarDAO objCalendarDAO;
    
    public CalendarBO() {
        this.objCalendarDAO=new CalendarDAO();
    }
    
    public List<Calendar>getAllCalendar(){
        return this.objCalendarDAO.readElements();
    }
    
    public boolean addCalendar(Calendar objCalendar){
        return this.objCalendarDAO.addElement(objCalendar);
    }
    
    public boolean deleteCalendar(int codigo){
        return this.objCalendarDAO.deleteElement(codigo);
    }
    
    public boolean updateCalendar(Calendar objCalendar){
        return this.objCalendarDAO.updateElement(objCalendar);
    }
    
    public Calendar getCalendar(int id){
        return this.objCalendarDAO.getElement(id);
    }
    
}
