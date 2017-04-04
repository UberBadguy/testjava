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
public class PageDAO {

    public PageDAO() {
    }
    
    public List listPageByProfile(int profileId){
        List listPages= new LinkedList();
        try{
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM PAGES WHERE ID IN (SELECT PAGE_ID FROM PROFILES_PAGES WHERE PROFILE_ID=?) ORDER BY PARENT";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, profileId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Page objPage= new Page(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));                
                listPages.add(objPage);
            }
        }catch(Exception e){
            System.out.println("Problemas en la extracción de información"+e.getMessage());
        }
        return listPages;
    }
}
