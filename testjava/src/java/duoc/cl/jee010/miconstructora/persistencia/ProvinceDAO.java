/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Province;
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
public class ProvinceDAO extends LogSystem{

    public ProvinceDAO() {
        this.setLogger();
    }

    public List listByRegion(int regionId){
        List listProvinces= new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM PROVINCES WHERE REGION_ID = ?";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, regionId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Province objProvince= new Province(rs.getInt(1), rs.getString(2), rs.getInt(3));                
                listProvinces.add(objProvince);
            }
        }catch(Exception e){
            LOGGER.error("Problemas en la extracción de información"+e.getMessage());
        }
        return listProvinces;
    }
}
