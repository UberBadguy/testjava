/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author amontess
 */
public class Calendar implements Serializable {

    private int id;
    private Time start;   
    private Time end;   
    private int rut;
    private Date date;
    private Employee employee;
    private int status;
    
    public Calendar() {
    }

    public Calendar(int id, Time start, Time end, int rut, Date date, int status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.rut = rut;
        this.date = date;
        this.status = status;
    }

    public Calendar(int id, Time start, Time end, int rut, Date date, int status, Employee employee) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.rut = rut;
        this.date = date;
        this.status = status;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Calendar{" + "id=" + id + ", start=" + start + ", end=" + end + ", rut=" + rut + ", date=" + date + ", employee=" + employee + ", status=" + status + '}';
    }
    
    
}
