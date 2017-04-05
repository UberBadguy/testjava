/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Calendar;
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
public class CalendarDAO implements ICrud{

    public CalendarDAO() {
    }
    
    @Override
    public boolean addElement(Object objetoInsert) {
        Calendar objCalendar=(Calendar)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO CALENDAR VALUES (0,?,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, objCalendar.getRut());
            ps.setTime(2, objCalendar.getStart());
            ps.setTime(3, objCalendar.getEnd());
            ps.setInt(4, objCalendar.getRut());
            ps.setDate(5, new Date(objCalendar.getDate().getTime()));
            ps.setInt(6, objCalendar.getStatus());
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
        List<Calendar>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM CALENDAR;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Calendar objCalendar= new Calendar(
                        rs.getInt(1), 
                        rs.getTime(2),
                        rs.getTime(3),
                        rs.getInt(4),
                        rs.getDate(5), 
                        rs.getInt(6));
                listadoUsuario.add(objCalendar);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Calendar objCalendar = (Calendar) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE CALENDAR SET START=?,END=?,RUT=?,DATE=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objCalendar.getRut());
            ps.setTime(2, objCalendar.getStart());
            ps.setTime(3, objCalendar.getEnd());
            ps.setInt(4, objCalendar.getRut());
            ps.setDate(5, new Date(objCalendar.getDate().getTime()));
            ps.setInt(6, objCalendar.getStatus());
            ps.setInt(7, objCalendar.getId());
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
            String query = "DELETE FROM CALENDAR WHERE ID=?";
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
            System.out.println("problemas al recuperar informacion "+e.getMessage());
        }
        return objCalendar;
    }
}
