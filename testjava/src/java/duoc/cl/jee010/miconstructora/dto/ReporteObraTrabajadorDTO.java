/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

/**
 *
 * @author Administrator
 */
public class ReporteObraTrabajadorDTO {
    
    private String rut;
    private String full_name;
    private String role;
    private int worked_hours;
    private int lagged_entry;

    public ReporteObraTrabajadorDTO() {
    }

    public ReporteObraTrabajadorDTO(String rut, String full_name, String role, int worked_hours, int lagged_entry) {
        this.rut = rut;
        this.full_name = full_name;
        this.role = role;
        this.worked_hours = worked_hours;
        this.lagged_entry = lagged_entry;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getWorked_hours() {
        return worked_hours;
    }

    public void setWorked_hours(int worked_hours) {
        this.worked_hours = worked_hours;
    }

    public int getLagged_entry() {
        return lagged_entry;
    }

    public void setLagged_entry(int lagged_entry) {
        this.lagged_entry = lagged_entry;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
