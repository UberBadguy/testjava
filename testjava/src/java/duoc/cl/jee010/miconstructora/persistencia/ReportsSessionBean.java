/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.EmployeePaymentDTO;
import duoc.cl.jee010.miconstructora.dto.ReportEmployeeDTO;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cetecom
 */
@Stateless
public class ReportsSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public List<ReportEmployeeDTO> buildingSiteXEmployee(int bsId){
        List<ReportEmployeeDTO> list = new LinkedList();
        try{
            Query q = em.createNativeQuery("SELECT "
                    + "CONCAT(e.RUT, '-', e.DV), "
                    + "CONCAT(e.NAME, ' ', e.LAST_NAME), "
                    + "p.NAME, "
                    + "b.NAME, "
                    + "COUNT(c.ID), "
                    + "SUM(HOUR(c.end) - HOUR(c.start)), "
                    + "(SELECT COUNT(*) FROM calendar c WHERE c.rut = e.rut AND c.start>'9:00') "
                    + "FROM EMPLOYEES e "
                    + "LEFT JOIN BUILDING_SITES B ON e.BUILDING_SITE_ID=b.ID "
                    + "LEFT JOIN CALENDAR c ON c.RUT = e.RUT "
                    + "LEFT JOIN USERS u ON u.EMPLOYEE_ID = e.ID "
                    + "LEFT JOIN PROFILES p ON u.PROFILE_ID = p.ID "
                    + "WHERE c.START IS NOT NULL "
                    + "AND b.ID = ? "
                    + "AND c.END IS NOT NULL", ReportEmployeeDTO.class);
            q.setParameter(1, bsId);
            list = q.getResultList();
        }catch(Exception e){
            
        }
        return list;
    }
    
    public List<ReportEmployeeDTO> buildingSiteXWorker(int bsId){
        List<ReportEmployeeDTO> list = new LinkedList();
        try{
            Query q = em.createNativeQuery("SELECT "
                    + "CONCAT(E.RUT, '-', E.DV), "
                    + "CONCAT(E.NAME, ' ', E.LAST_NAME), "
                    + "P.NAME, "
                    + "B.NAME, "
                    + "COUNT(C.ID), "
                    + "SUM(HOUR(c.end) - HOUR(c.start)), "
                    + "(SELECT COUNT(*) FROM calendar C WHERE c.rut = e.rut AND c.start>'9:00') "
                    + "FROM EMPLOYEES E "
                    + "LEFT JOIN BUILDING_SITES B ON E.BUILDING_SITE_ID=B.ID "
                    + "LEFT JOIN CALENDAR C ON C.RUT = E.RUT "
                    + "LEFT JOIN USERS U ON U.EMPLOYEE_ID = E.ID "
                    + "LEFT JOIN PROFILES P ON U.PROFILE_ID = P.ID "
                    + "WHERE C.START IS NOT NULL "
                    + "AND B.ID = ? "
                    + "AND P.ID NOT IN (1,2,3)"
                    + "AND C.END IS NOT NULL", ReportEmployeeDTO.class);
            q.setParameter(1, bsId);
            list = q.getResultList();
        }catch(Exception e){
            
        }
        return list;
    }
    
    public List<ReportEmployeeDTO> AllEmployeesDetailed(){
        List<ReportEmployeeDTO> list = new LinkedList();
        try{
            Query q = em.createNativeQuery("SELECT "
                    + "CONCAT(E.RUT, '-', E.DV), "
                    + "CONCAT(E.NAME, ' ', E.LAST_NAME), "
                    + "P.NAME, "
                    + "B.NAME, "
                    + "COUNT(C.ID), "
                    + "SUM(HOUR(c.end) - HOUR(c.start)), "
                    + "(SELECT COUNT(*) FROM calendar C WHERE c.rut = e.rut AND c.start>'9:00') "
                    + "FROM EMPLOYEES E "
                    + "LEFT JOIN BUILDING_SITES B ON E.BUILDING_SITE_ID=B.ID "
                    + "LEFT JOIN CALENDAR C ON C.RUT = E.RUT "
                    + "LEFT JOIN USERS U ON U.EMPLOYEE_ID = E.ID "
                    + "LEFT JOIN PROFILES P ON U.PROFILE_ID = P.ID "
                    + "WHERE C.START IS NOT NULL "
                    + "AND C.END IS NOT NULL", ReportEmployeeDTO.class);
            list = q.getResultList();
        }catch(Exception e){
            
        }
        return list;
    }
       
    public List<EmployeePaymentDTO> AllPayments(){
        List<EmployeePaymentDTO> list = new LinkedList();
        try{
            Query q = em.createNativeQuery("SELECT "
                    + "CONCAT(E.RUT, '-', E.DV), "
                    + "CONCAT(E.NAME, ' ', E.LAST_NAME), "
                    + "P.NAME, "
                    + "(SELECT COUNT(*) FROM calendar C WHERE c.rut = e.rut AND c.start>'9:00'), "
                    + "SUM(HOUR(c.end) - HOUR(c.start)), "
                    + "E.VALUE_PER_HOUR, "
                    + "SUM(HOUR(c.end) - HOUR(c.start))*E.VALUE_PER_HOUR, "
                    + "E.PAYMENT_METHOD "
                    + "FROM EMPLOYEES E "
                    + "LEFT JOIN BUILDING_SITES B ON E.BUILDING_SITE_ID=B.ID "
                    + "LEFT JOIN CALENDAR C ON C.RUT = E.RUT "
                    + "LEFT JOIN USERS U ON U.EMPLOYEE_ID = E.ID "
                    + "LEFT JOIN PROFILES P ON U.PROFILE_ID = P.ID "
                    + "WHERE C.START IS NOT NULL "
                    + "AND C.END IS NOT NULL", EmployeePaymentDTO.class);
            list = q.getResultList();
        }catch(Exception e){
            
        }
        return list;
        
}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
