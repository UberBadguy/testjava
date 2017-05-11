/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.EmployeesDTO;
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
}
