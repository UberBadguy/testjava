/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.BuildingSitesDTO;
import duoc.cl.jee010.miconstructora.dto.EmployeesDTO;
import duoc.cl.jee010.miconstructora.entidades.Employee;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cetecom
 */
@Stateless
public class EmployeeSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public EmployeesDTO allEmployees() {
        EmployeesDTO employeesDTO = null;
        try {
            employeesDTO = em.createNamedQuery("Employee.findAll", EmployeesDTO.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return employeesDTO;
    }
    
    public EmployeesDTO getEmployee(int id){
        EmployeesDTO employeeDTO = null;
        try {
            employeeDTO = em.createNamedQuery("Employee.findById", EmployeesDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return employeeDTO;
    }
    
    public EmployeesDTO getEmployeeByRut(int rut){
        EmployeesDTO employeeDTO = null;
        try {
            employeeDTO = em.createNamedQuery("Employee.findByRut", EmployeesDTO.class)
                    .setParameter("rut", rut)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return employeeDTO;
    }
    
    public boolean updateEmployee(EmployeesDTO employee) {
        Employee emp = employee.getEmployee();
        try {
            em.merge(emp);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean addEmployee(EmployeesDTO employee) {
        Employee emp = employee.getEmployee();
        try {
            em.persist(emp);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public Employee createEmployee(int id, int rutAux, String dv, String name, String last_name, Date birth_date, String gender, BuildingSitesDTO building_site, String payment_method, int account_number, String bank, int value_per_hour, int status){
        Employee employee = new Employee(id, rutAux, dv, name, last_name, birth_date, gender, payment_method, value_per_hour, bank, account_number, status);
        employee.setBuildingSiteId(building_site.getBuildingSite());
        
        return employee;
    }
}