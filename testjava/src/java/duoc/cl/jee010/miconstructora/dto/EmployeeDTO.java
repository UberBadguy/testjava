/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Employee;

/**
 *
 * @author cetecom
 */
public class EmployeeDTO {
    
    private static final long serialVersionUID = 1L;
    private Employee employee;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
