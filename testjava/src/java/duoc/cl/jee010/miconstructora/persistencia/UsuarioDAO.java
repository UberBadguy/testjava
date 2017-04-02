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
public class UsuarioDAO implements ICrud{

    public UsuarioDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        User objUsuario=(User)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO USUARIO VALUES (0,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin());
            ps.setString(2, objUsuario.getPassword());
            ps.setInt(3, objUsuario.getProfile_id());
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
    public List readElementos() {
        List<User>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM USUARIO ;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User objUsuario= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listadoUsuario.add(objUsuario);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    public List readUsuariosPerfilDTO(){
        List<UsuarioPerfilDTO>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT USU.ID_USUARIO,USU.LOGIN_USUARIO,USU.PASS_USUARIO,USU.ID_PERFIL,PER.NOMBRE_PERFIL FROM USUARIO USU,"
                    + " PERFIL PER WHERE PER.ID_PERFIL=USU.ID_PERFIL ;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                UsuarioPerfilDTO objUsuarioPerfilDTO= new UsuarioPerfilDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                listadoUsuario.add(objUsuarioPerfilDTO);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
           User objUsuario = (User) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE USUARIO SET LOGIN_USUARIO=?,PASS_USUARIO=?,ID_PERFIL=? WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin());
            ps.setString(2, objUsuario.getPassword());
            ps.setInt(3, objUsuario.getProfile_id());
            ps.setInt(4, objUsuario.getId());
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
    public boolean deleteElemento(int codigo) {
         try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
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
    
    public User validaIngreso(String login,String pass){
        User objUsuario=null;
        String query="SELECT * FROM USUARIO WHERE LOGIN_USUARIO=? AND PASS_USUARIO=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,login);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objUsuario= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }catch(Exception e){
            System.out.println("problemas al validar "+e.getMessage());
        }
        return objUsuario;
    }
    
    public User buscaUsuarioXcodigo(int id_usuario) {
        User infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                infoUsuario = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;
    }
    
}
