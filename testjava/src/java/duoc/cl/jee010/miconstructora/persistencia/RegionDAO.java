/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.Region;
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
public class RegionDAO extends LogSystem{

    public RegionDAO() {
        this.setLogger();
    }
    
    public List listAll(){
        List listRegions= new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM REGIONS";
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Region objRegion= new Region(rs.getInt(1), rs.getString(2), rs.getString(3));                
                listRegions.add(objRegion);
            }
        }catch(Exception e){
            LOGGER.error("Problemas en la extracción de información"+e.getMessage());
        }
        return listRegions;
    }
}
