/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.entidades.District;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class DistrictDAO {

    public DistrictDAO() {
    }
    
    public List listByProvince(int provinceId){
        List listDistricts;
        listDistricts = new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM DISTRICTS WHERE PROVINCES_ID = ?";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, provinceId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                District objDistrict= new District(rs.getInt(1), rs.getString(2), rs.getInt(3));                
                listDistricts.add(objDistrict);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información"+e.getMessage());
        }
        return listDistricts;
    }
}
