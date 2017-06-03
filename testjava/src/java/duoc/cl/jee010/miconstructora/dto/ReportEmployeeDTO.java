/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

/**
 *
 * @author cetecom
 */
public class ReportEmployeeDTO {
    
    private static final long serialVersionUID = 1L;
    
    private String rut;
    private String full_name;
    private String role;
    private String building_site_name;
    private int worked_days;
    private int worked_hours;
    private int delayed_entry;

    public ReportEmployeeDTO() {
    }

    public ReportEmployeeDTO(String rut, String full_name, String role, String building_site_name, int worked_days, int worked_hours, int delayed_entry) {
        this.rut = rut;
        this.full_name = full_name;
        this.role = role;
        this.building_site_name = building_site_name;
        this.worked_days = worked_days;
        this.worked_hours = worked_hours;
        this.delayed_entry = delayed_entry;
    }

    public int getWorked_days() {
        return worked_days;
    }

    public void setWorked_days(int worked_days) {
        this.worked_days = worked_days;
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

    public int getDelayed_entry() {
        return delayed_entry;
    }

    public void setDelayed_entry(int delayed_entry) {
        this.delayed_entry = delayed_entry;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBuilding_site_name() {
        return building_site_name;
    }

    public void setBuilding_site_name(String building_site_name) {
        this.building_site_name = building_site_name;
    }
}
