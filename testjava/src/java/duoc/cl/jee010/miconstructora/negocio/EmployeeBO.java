/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.persistencia.EmployeeDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amontess
 */
public class EmployeeBO {
    
    private final EmployeeDAO objEmployeeDAO;
    
    public EmployeeBO() {
        this.objEmployeeDAO=new EmployeeDAO();
    }
    
    public List<Employee>getAllEmployees(){
        return this.objEmployeeDAO.readElements();
    }
    
    public boolean addEmployee(Employee objEmployee){
        return this.objEmployeeDAO.addElement(objEmployee);
    }
    
    public boolean deleteEmployee(int codigo){
        return this.objEmployeeDAO.deleteElement(codigo);
    }
    
    public boolean updateEmployee(Employee objEmployee){
        return this.objEmployeeDAO.updateElement(objEmployee);
    }
    
    public Employee getEmployee(int codigo){
        return this.objEmployeeDAO.getElement(codigo);
    }
    
    public Employee getEmployeeByRUT(int rut){
        return this.objEmployeeDAO.getElementbyRut(rut);
    }
    
    public List<Employee>getAllAvailableEmployees(){
        return this.objEmployeeDAO.getAllAvailableEmployees();
    }
    
    public List<Employee>getAllEmployeesCalendar(){
        return this.objEmployeeDAO.readElementsCalendar();
    }
    
}
