/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class EmployeeDAO implements ICrud{

    public EmployeeDAO() {
    }

    @Override
    public boolean addElement(Object objetoInsert) {
        Employee objEmployee=(Employee)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO EMPLOYEES VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, objEmployee.getRut());
            ps.setString(2, objEmployee.getDv());
            ps.setString(3, objEmployee.getName());
            ps.setString(4, objEmployee.getLast_name());
            ps.setDate(5, new Date(objEmployee.getBirth().getTime()));
            ps.setString(6, objEmployee.getGender());
            ps.setInt(7, objEmployee.getBuilding_site_id());
            ps.setString(8, objEmployee.getPayment_method());
            ps.setString(9, objEmployee.getAccount_number());
            ps.setString(10, objEmployee.getBank());
            ps.setInt(11, objEmployee.getValue_per_hour());
            ps.setString(12, objEmployee.getGender());
            ps.setInt(13, objEmployee.getStatus());
            try{
                return ps.executeUpdate()==1;
            }catch(Exception e){
                System.out.println("problemas al insertar en la bd "+e.getMessage());
                return false;
            }
        }catch(Exception e){
            System.out.println("problemas para insertar en la BD"+e.getMessage());
        }
        return false;
    }

    @Override
    public List readElements() {
        List<Employee>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM EMPLOYEES;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee objEmployee= new Employee(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getDate(6), 
                        rs.getString(7), 
                        rs.getInt(8),
                        rs.getString(9), 
                        rs.getString(10), 
                        rs.getString(11), 
                        rs.getInt(12), 
                        rs.getInt(13));
                listadoUsuario.add(objEmployee);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Employee objEmployee = (Employee) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE EMPLOYEES SET RUT=?,DV=?,NAME=?,LAST_NAME=?,BIRTH_DATE=?,GENDER=?,BUILDING_SITE_ID=?,PAYMENT_METHOD=?,ACCOUNT_NUMBER=?,BANK=?,VALUE_PER_HOUR=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objEmployee.getRut());
            ps.setString(2, objEmployee.getDv());
            ps.setString(3, objEmployee.getName());
            ps.setString(4, objEmployee.getLast_name());
            ps.setDate(5, new Date(objEmployee.getBirth().getTime()));
            ps.setString(6, objEmployee.getGender());
            ps.setInt(7, objEmployee.getBuilding_site_id());
            ps.setString(8, objEmployee.getPayment_method());
            ps.setString(9, objEmployee.getAccount_number());
            ps.setString(10, objEmployee.getBank());
            ps.setInt(11, objEmployee.getValue_per_hour());
            ps.setString(12, objEmployee.getGender());
            ps.setInt(13, objEmployee.getStatus());
            ps.setInt(14, objEmployee.getId());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al updatear"+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElement(int id) {
         try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE EMPLOYEES SET STATUS = 0 WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
        return false;
    }
     
    @Override
    public Employee getElement(int id){
        Employee objEmployee=null;
        String query="SELECT * FROM EMPLOYEES WHERE ID=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    objEmployee= new Employee(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getDate(6), 
                        rs.getString(7), 
                        rs.getInt(8),
                        rs.getString(9), 
                        rs.getString(10), 
                        rs.getString(11), 
                        rs.getInt(12), 
                        rs.getInt(13));
            }
        }catch(Exception e){
            System.out.println("problemas al recuperar informacion "+e.getMessage());
        }
        return objEmployee;
    }
    
    public List getAllAvailableEmployees() {
        List<Employee>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM EMPLOYEES WHERE ID NOT IN (SELECT EMPLOYEE_ID FROM USERS);";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee objEmployee= new Employee(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getDate(6), 
                        rs.getString(7), 
                        rs.getInt(8),
                        rs.getString(9), 
                        rs.getString(10), 
                        rs.getString(11), 
                        rs.getInt(12), 
                        rs.getInt(13));
                listadoUsuario.add(objEmployee);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
}
