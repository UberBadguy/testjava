/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Calendar;
import duoc.cl.jee010.miconstructora.entidades.Employee;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
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
public class CalendarDAO extends LogSystem implements ICrud{

    public CalendarDAO() {
        this.setLogger();
    }
    
    @Override
    public boolean addElement(Object objetoInsert) {
        Calendar objCalendar=(Calendar)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO CALENDAR VALUES (0,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setTime(1, objCalendar.getStart());
            ps.setTime(2, objCalendar.getEnd());
            ps.setInt(3, objCalendar.getRut());
            ps.setDate(4, new Date(objCalendar.getDate().getTime()));
            ps.setInt(5, objCalendar.getStatus());
            try{
                return ps.executeUpdate()==1;
            }catch(Exception e){
                LOGGER.error("problemas al insertar en la bd "+e.getMessage());
                return false;
            }
        }catch(Exception e){
            LOGGER.error("problemas para insertar en la BD"+e.getMessage());
        }
        return false;
    }

    @Override
    public List readElements() {
        List<Calendar>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM CALENDAR C LEFT JOIN EMPLOYEES E ON C.RUT = E.RUT LEFT JOIN BUILDING_SITES B ON E.BUILDING_SITE_ID = B.ID;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt(7), 
                        rs.getInt(8), 
                        rs.getString(9),
                        rs.getString(10), 
                        rs.getString(11), 
                        rs.getDate(12), 
                        rs.getString(13), 
                        rs.getInt(14),
                        rs.getString(15), 
                        rs.getString(16), 
                        rs.getString(17), 
                        rs.getInt(18), 
                        rs.getInt(19), 
                        rs.getString(21)
                );
                Calendar objCalendar = new Calendar(
                        rs.getInt(1), 
                        rs.getTime(2),
                        rs.getTime(3),
                        rs.getInt(4),
                        rs.getDate(5), 
                        rs.getInt(6),
                        employee);
                listadoUsuario.add(objCalendar);
            }            
        }catch(Exception e){
            LOGGER.error("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Calendar objCalendar = (Calendar) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE CALENDAR SET RUT=?,START=?,END=?,DATE=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objCalendar.getRut());
            ps.setTime(2, objCalendar.getStart());
            ps.setTime(3, objCalendar.getEnd());
            ps.setDate(4, new Date(objCalendar.getDate().getTime()));
            ps.setInt(5, objCalendar.getStatus());
            ps.setInt(6, objCalendar.getId());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                LOGGER.error("Problemas al updatear"+e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.error("No se pudo updatear la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElement(int id) {
         try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE CALENDAR SET STATUS = 0 WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                LOGGER.error("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.error("Error al borrar los registros" + e.getMessage());
        }
        return false;
    }
     
    @Override
    public Calendar getElement(int id){
        Calendar objCalendar=null;
        String query="SELECT * FROM CALENDAR WHERE RUT=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objCalendar= new Calendar(
                        rs.getInt(1), 
                        rs.getTime(2),
                        rs.getTime(3),
                        rs.getInt(4),
                        rs.getDate(5), 
                        rs.getInt(6));
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return objCalendar;
    }
    public Calendar getElementByDate(String date, int rut){
        Calendar objCalendar=null;
        String query="SELECT * FROM CALENDAR WHERE DATE =? AND RUT = ?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, rut);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objCalendar= new Calendar(
                        rs.getInt(1), 
                        rs.getTime(2),
                        rs.getTime(3),
                        rs.getInt(4),
                        rs.getDate(5), 
                        rs.getInt(6));
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return objCalendar;
    }
}
