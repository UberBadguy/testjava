/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.propiedades.config;

import duoc.cl.jee010.miconstructora.utilidades.LogSystem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Joe-Xidu
 */
public class ConfigProperties extends LogSystem{

    private final String file = "config.properties";
    private final HashMap<String, String> properties;
    
    public ConfigProperties() {
        this.setLogger();
        this.setProperties();
        this.properties = new HashMap<>();
    }
    
    public HashMap<String,String> getConfigProperties() {
        Properties prop = new Properties();
    	InputStream input = null;

    	try {
            input = new FileInputStream(this.file);
            prop.load(input);
            Enumeration<?> e = prop.propertyNames();
            String key, value;
            
            while (e.hasMoreElements()) {
                key = (String) e.nextElement();
                value = prop.getProperty(key);
                this.properties.put(key, value);
            }
	} catch (IOException ex) {
            LOGGER.fatal("Error al establecer configuraciones "+ex.getMessage());
	} finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.fatal("Error al cerrar el archivo "+e.getMessage());
                }
            }
	}
        
        return this.properties;
    }
    
    private void setProperties() {
        Properties prop = new Properties();
	OutputStream output = null;

	try {
            output = new FileOutputStream(this.file);
            prop.setProperty("driver", "com.mysql.jdbc.Driver");
            prop.setProperty("url", "jdbc:mysql://localhost:3306/");
            prop.setProperty("database", "constructora");
            prop.setProperty("dbuser", "root");
            prop.setProperty("dbpassword", "");
            prop.store(output, null);
	} catch (IOException io) {
            LOGGER.fatal("Error al establecer configuraciones "+io.getMessage());
	} finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    LOGGER.fatal("Error al cerrar el archivo "+e.getMessage());
                }
            }

	}
    }
}
