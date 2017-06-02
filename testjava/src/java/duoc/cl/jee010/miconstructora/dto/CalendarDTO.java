/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Calendar;
import java.util.List;

/**
 *
 * @author jose.becerra
 */
public class CalendarDTO {
    
    private static final long serialVersionUID = 1L;
    private List<Calendar> calendars;
    private Calendar calendar;

    public CalendarDTO(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public CalendarDTO(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    
    
}
