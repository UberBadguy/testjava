/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.CalendarDTO;
import duoc.cl.jee010.miconstructora.dto.EmployeesDTO;
import duoc.cl.jee010.miconstructora.entidades.Calendar;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose.becerra
 */
@Stateless
public class CalendarSessionBean {
    @PersistenceContext
    private EntityManager em;

    public CalendarDTO allCalendar() {
        CalendarDTO calendarDTO = null;
        try {
            calendarDTO = em.createNamedQuery("BuildingSite.findAll", CalendarDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return calendarDTO;
    }
    
    public CalendarDTO getCalendar(int id){
        CalendarDTO calendarDTO = null;
        try {
            calendarDTO = em.createNamedQuery("BuildingSite.findById", CalendarDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return calendarDTO;
    }
    
    public CalendarDTO getCalendarByDate(int rut, Date date){
        CalendarDTO calendarDTO = null;
        try {
            calendarDTO = em.createNamedQuery("BuildingSite.findById", CalendarDTO.class)
                    .setParameter("rut", rut)
                    .setParameter("date", date)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return calendarDTO;
    }
    
    public Calendar createCalendar(int id, Date date, Date start, Date end, int status, EmployeesDTO employee){
        Calendar calendar = new Calendar(id, date, start, end, status);
        calendar.setRut(employee.getEmployee());
        
        return calendar;
    }
    
    public boolean updateCalendar(CalendarDTO calendarDTO) {
        Calendar calendar = calendarDTO.getCalendar();
        try {
            em.merge(calendar);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean addCalendar(CalendarDTO calendarDTO) {
        Calendar calendar = calendarDTO.getCalendar();
        try {
            em.persist(calendar);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
