/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Employee;
import java.sql.Connection;
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
        Employee objUsuario=(Employee)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO EMPLOYEES VALUES (0,?,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(6, objUsuario.getStatus());
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
            String query="SELECT U.ID, U.LOGIN, U.PASSWORD, U.EMAIL, U.PROFILE_ID, U.EMPLOYEE_ID, U.STATUS, P.NAME FROM USERS U, PROFILES P WHERE U.PROFILE_ID = P.ID;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee objUsuario= new Employee();
                listadoUsuario.add(objUsuario);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Employee objUsuario = (Employee) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE USERS SET LOGIN=?,PASSWORD=?,EMAIL=?,PROFILE_ID=?,EMPLOYEE_ID=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(6, objUsuario.getStatus());
            ps.setInt(7, objUsuario.getId());
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
            String query = "DELETE FROM USERS WHERE ID=?";
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
        String query="SELECT U.ID, U.LOGIN, U.PASSWORD, U.EMAIL, U.PROFILE_ID, U.EMPLOYEE_ID, U.STATUS, P.NAME FROM USERS U, PROFILES P WHERE U.PROFILE_ID = P.ID AND U.ID=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    objEmployee= new Employee();
            }
        }catch(Exception e){
            System.out.println("problemas al recuperar informacion "+e.getMessage());
        }
        return objEmployee;
    }
}
