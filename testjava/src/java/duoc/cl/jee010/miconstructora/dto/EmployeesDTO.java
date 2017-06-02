/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class EmployeesDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Employee> employees;
    private Employee employee;

    public EmployeesDTO() {
    }

    public EmployeesDTO(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeesDTO(Employee employee) {
        this.employee = employee;
    }
    
    

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "{\"data\":{" +
                "\"id\":" + this.employee.getId() +
                ",\"rut\":\"" + this.employee.getRut() + "-" + this.employee.getDv() + "\"" +
                ",\"name\":\"" + this.employee.getName() + "\"" +
                ",\"last_name\":\"" + this.employee.getLastName() + "\"" +
                ",\"birth\":\"" + formatter.format(this.employee.getBirthDate()) + "\"" +
                ",\"gender\":\"" + this.employee.getGender() + "\"" +
                ",\"building_site_id\":" + this.employee.getBuildingSiteId().getId() +
                ",\"payment_method\":\"" + this.employee.getPaymentMethod() + "\"" +
                ",\"building_site_name\":\"" + this.employee.getBuildingSiteId().getName() + "\"" +
                ",\"account_number\":\"" + this.employee.getAccountNumber() + "\"" + 
                ",\"bank\":\"" + this.employee.getBank() + "\"" + 
                ",\"value_per_hour\":" + this.employee.getValuePerHour() +
                ",\"status\":" + this.employee.getStatus() +"}}";
    }
    
    
}
