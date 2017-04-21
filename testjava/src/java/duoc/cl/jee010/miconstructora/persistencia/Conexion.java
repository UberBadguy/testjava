/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.propiedades.config.ConfigProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import org.apache.log4j.Logger;
/**
 *
 * @author amontess
 */
public class Conexion {
    static final Logger LOGGER = Logger.getLogger(Conexion.class);
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
            LOGGER.fatal("Error fatal de coneion a DB. "+e.getMessage());
            throw new ConexionException("error al conectar la BD "+e.getMessage());
        }
        return con;
    }    
}
