/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

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
public class BuildingSiteDAO extends LogSystem implements ICrud{

    public BuildingSiteDAO() {
        this.setLogger();
    }
    
@Override
    public boolean addElement(Object objetoInsert) {
        BuildingSite objBuildingSite=(BuildingSite)objetoInsert;
        try{
            Connection con=Conexion.getConexion();
            String query="INSERT INTO BUILDING_SITES VALUES (0,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, objBuildingSite.getName());
            ps.setString(2, objBuildingSite.getAddress());
            ps.setInt(3, objBuildingSite.getDistrict_id());
            ps.setInt(4, objBuildingSite.getStatus());
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
        List<BuildingSite>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT B.ID, B.NAME, B.ADDRESS, D.NAME, P.NAME, CONCAT(R.ORDINAL,' ',R.NAME), B.STATUS FROM BUILDING_SITES B LEFT JOIN DISTRICTS D ON D.ID=B.DISTRICT_ID LEFT JOIN PROVINCES P ON P.ID = D.PROVINCES_ID LEFT JOIN REGIONS R ON P.REGION_ID = R.ID;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                BuildingSite objBuildingSite= new BuildingSite(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                listadoUsuario.add(objBuildingSite);
            }            
        }catch(Exception e){
            LOGGER.error("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
    
    @Override
    public boolean updateElement(Object objetoUpdate) {
           BuildingSite objBuildingSite = (BuildingSite) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE BUILDING_SITES SET NAME=?,ADDRESS=?,DISTRICT_ID=?,STATUS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objBuildingSite.getName());
            ps.setString(2, objBuildingSite.getAddress());
            ps.setInt(3, objBuildingSite.getDistrict_id());
            ps.setInt(4, objBuildingSite.getStatus());
            ps.setInt(5, objBuildingSite.getId());
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
            String query = "UPDATE BUILDING_SITES SET STATUS=0 WHERE ID=?";
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
    public BuildingSite getElement(int id){
        BuildingSite objBuildingSite=null;
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT B.ID, B.NAME, B.ADDRESS, D.NAME, P.NAME, CONCAT(R.ORDINAL,' ',R.NAME), B.STATUS FROM BUILDING_SITES B LEFT JOIN DISTRICTS D ON D.ID=B.DISTRICT_ID LEFT JOIN PROVINCES P ON P.ID = D.PROVINCES_ID LEFT JOIN REGIONS R ON P.REGION_ID = R.ID WHERE B.ID = ?;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                objBuildingSite= new BuildingSite(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        }catch(Exception e){
            LOGGER.error("problemas al recuperar informacion "+e.getMessage());
        }
        return objBuildingSite;
    }
}
