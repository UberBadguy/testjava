/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.dto.UsuarioPerfilDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UserDAO implements ICrud{

    public UserDAO() {
    }

    @Override
    public boolean addElement(Object objetoInsert) {
        User objUsuario=(User)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO USER VALUES (0,?,?,?,?,?,?);";
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
        List<User>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM USUARIO ;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User objUsuario= new User(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                listadoUsuario.add(objUsuario);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           User objUsuario = (User) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE USER SET LOGIN=?,PASSWORD=?,EMAIL=?,PROFILE_ID=?,EMPLOYEE_ID=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin());
            ps.setString(2, objUsuario.getPassword());
            ps.setString(3, objUsuario.getEmail());
            ps.setInt(4, objUsuario.getProfile_id());
            ps.setInt(5, objUsuario.getEmployee_id());
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
            String query = "DELETE FROM USER WHERE ID=?";
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
    
    public User authenticate(String login,String password){
        User objUser=null;
        String query="SELECT * FROM USER WHERE LOGIN=? AND PASSWORD=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    objUser= new User(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        }catch(Exception e){
            System.out.println("problemas al validar "+e.getMessage());
        }
        return objUser;
    }
    
    @Override
    public User getElement(int id){
        User objUser=null;
        String query="SELECT * FROM USER WHERE ID=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    objUser= new User(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        }catch(Exception e){
            System.out.println("problemas al recuperar informacion "+e.getMessage());
        }
        return objUser;
    }
  
}