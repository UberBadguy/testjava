/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.EmployeePaymentDTO;
import duoc.cl.jee010.miconstructora.dto.ReportEmployeeDTO;
import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ReportDAO extends LogSystem{

    public ReportDAO() {
        this.setLogger();
    }
    
    public List<ReportEmployeeDTO> buildingSiteXEmployee(int bsId){
        List<ReportEmployeeDTO> list = new LinkedList();
        ReportEmployeeDTO objReportEmpoyeeDTO=null;
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT "
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
                    + "AND C.END IS NOT NULL;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, bsId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objReportEmpoyeeDTO = new ReportEmployeeDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(objReportEmpoyeeDTO);
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return list;
    }
    
    public List<ReportEmployeeDTO> buildingSiteXWorker(int bsId){
        List<ReportEmployeeDTO> list = new LinkedList();
        ReportEmployeeDTO objReportEmpoyeeDTO=null;
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT "
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
                    + "AND C.END IS NOT NULL;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, bsId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objReportEmpoyeeDTO = new ReportEmployeeDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(objReportEmpoyeeDTO);
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return list;
    }
    
       public List<ReportEmployeeDTO> AllEmployeesDetailed(){
        List<ReportEmployeeDTO> list = new LinkedList();
        ReportEmployeeDTO objReportEmpoyeeDTO=null;
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT "
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
                    + "AND C.END IS NOT NULL;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objReportEmpoyeeDTO = new ReportEmployeeDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(objReportEmpoyeeDTO);
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return list;
    }
       
       public List<EmployeePaymentDTO> AllPayments(){
        List<EmployeePaymentDTO> list = new LinkedList();
        EmployeePaymentDTO objEmployeePaymentDTO=null;
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT "
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
                    + "AND C.END IS NOT NULL;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objEmployeePaymentDTO = new EmployeePaymentDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8));
                list.add(objEmployeePaymentDTO);
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return list;
    }
}
