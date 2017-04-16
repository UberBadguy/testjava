/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Page;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PageDAO implements ICrud{

    public PageDAO() {
    }
    
    public List listPageByProfile(int profileId){
        List listPages= new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT ID,NAME,PATH,ICON,PARENT,STATUS FROM PAGES WHERE ID IN (SELECT PAGE_ID FROM PROFILES_PAGES WHERE PROFILE_ID=?) AND STATUS = 1 ORDER BY ID";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, profileId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Page objPage= new Page(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getInt(5), 
                        rs.getInt(6));                
                listPages.add(objPage);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información "+e.getMessage());
        }
        return listPages;
    }

    @Override
    public boolean addElement(Object objetoInsert) {
        Page objPage=(Page)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO PAGES VALUES (0,?,?,?,?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, objPage.getName());
            ps.setString(2, objPage.getPath());
            ps.setString(3, objPage.getIcon());
            ps.setInt(4, objPage.getParent());
            ps.setInt(5, objPage.getStatus());
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
        List<Page>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT * FROM PAGES;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Page objPage= new Page(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                listadoUsuario.add(objPage);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           Page objPage = (Page) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE PAGES SET NAME=?,PATH=?,ICON=?,PARENT=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objPage.getName());
            ps.setString(2, objPage.getPath());
            ps.setString(3, objPage.getIcon());
            ps.setInt(4, objPage.getParent());
            ps.setInt(5, objPage.getStatus());
            ps.setInt(6, objPage.getId());
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
            String query = "UPDATE PAGES SET STATUS = 0 WHERE ID=?";
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
    public Page getElement(int id){
        Page objPage=null;
        String query="SELECT ID,NAME,PATH,ICON,PARENT,STATUS FROM PAGES WHERE ID=?;";
        try{
            Connection con= Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objPage= new Page(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3), 
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6));
            }
        }catch(Exception e){
            System.out.println("problemas al recuperar informacion "+e.getMessage());
        }
        return objPage;
    }
    
    public List getAllAvailableParents() {
        List<Page> listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT ID,NAME,PATH,ICON,PARENT,STATUS FROM PAGES WHERE PATH='#';";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                    Page objPage= new Page(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                listadoUsuario.add(objPage);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
}
