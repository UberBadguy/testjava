/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.config.propiedades.ConfigProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 *
 * @author amontess
 */
public class Conexion {
    public static Connection getConexion() throws ConexionException{
        Connection con=null;
        try{
            ConfigProperties cp = new ConfigProperties();
            HashMap<String, String> properties = cp.getConfigProperties();
            String driverClassName = properties.get("driver");
            String driverUrl = properties.get("url") + properties.get("database");
            Class.forName(driverClassName);
            con = DriverManager.getConnection(driverUrl,properties.get("dbuser"),properties.get("dbpassword"));
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new ConexionException("error al conectar la BD "+e.getMessage());
        }
        return con;
    }    
}
