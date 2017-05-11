/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class EmployeesDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Employee> employees;

    public EmployeesDTO() {
    }

    public EmployeesDTO(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
}
