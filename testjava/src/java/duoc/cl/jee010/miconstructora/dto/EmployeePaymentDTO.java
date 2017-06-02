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
public class EmployeePaymentDTO {
    
    private String rut;
    private String full_name;
    private String role;
    private int worked_hours;
    private int delayed_entry;
    private int value_per_hour;
    private int total_payment;
    private String payment_method;

    public EmployeePaymentDTO() {
    }

    public EmployeePaymentDTO(String rut, String full_name, String role, int worked_hours, int delayed_entry, int value_per_hour, int total_payment, String payment_method) {
        this.rut = rut;
        this.full_name = full_name;
        this.role = role;
        this.worked_hours = worked_hours;
        this.delayed_entry = delayed_entry;
        this.value_per_hour = value_per_hour;
        this.total_payment = total_payment;
        this.payment_method = payment_method;
    }

    public int getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(int total_payment) {
        this.total_payment = total_payment;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getValue_per_hour() {
        return value_per_hour;
    }

    public void setValue_per_hour(int value_per_hour) {
        this.value_per_hour = value_per_hour;
    }
    
    

}
