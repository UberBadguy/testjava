/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.dto.UserProfilePagesDTO;
import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ProfileDAO extends LogSystem implements ICrud{

    public ProfileDAO() {
        this.setLogger();
    }

    @Override
    public boolean addElement(Object objetoInsert) {
        User objUsuario=(User)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO USERS VALUES (0,?,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin());
            ps.setString(2, objUsuario.getPassword());
            ps.setString(3, objUsuario.getEmail());
            ps.setInt(4, objUsuario.getProfile_id());
            ps.setInt(5, objUsuario.getEmployee_id());
            ps.setInt(6, objUsuario.getStatus());
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
        List<Profile> listProfile= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM PROFILES WHERE STATUS = 1;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Profile objProfile= new Profile(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3));
                listProfile.add(objProfile);
            }            
        }catch(Exception e){
            LOGGER.error("Problemas en la lectura "+e.getMessage());
        }
        return listProfile;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Profile objProfile = (Profile) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE PROFILES SET NAME=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objProfile.getName());
            ps.setInt(2, objProfile.getStatus());
            ps.setInt(3, objProfile.getId());

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
            String query = "UPDATE PROFILES SET STATUS = 0 WHERE ID=?";
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
    public Profile getElement(int id){
        Profile objUser=null;
        String query="SELECT * FROM PROFILES WHERE ID=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    objUser= new Profile(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3));
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return objUser;
    }
}
