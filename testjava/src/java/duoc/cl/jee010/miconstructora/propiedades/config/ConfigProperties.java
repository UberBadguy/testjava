/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.propiedades.config;

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
public class ConfigProperties {

    String file = "config.properties";
    
    public ConfigProperties() {
    }
    
    public HashMap<String,String> getConfigProperties() {
        HashMap<String,String> properties = new HashMap<>();
        Properties prop = new Properties();
    	InputStream input = null;

    	try {
            input = getClass().getClassLoader().getResourceAsStream(file);
            if (input == null) {
                this.setProperties();
                input = getClass().getClassLoader().getResourceAsStream(file);
                System.out.println(input);
            }

            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            String key, value;
            while (e.hasMoreElements()) {
                key = (String) e.nextElement();
                value = prop.getProperty(key);
                properties.put(key, value);
            }
	} catch (IOException ex) {
                System.out.println(input);
		ex.printStackTrace();
	} finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
	}
        
        return properties;
    }
    
    public void setProperties() {
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
                System.out.println(prop);

	} catch (IOException io) {
            io.printStackTrace();
	} finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

	}
    }
}
