/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.utilidades;

import org.apache.log4j.Logger;
/**
 *
 * @author Administrator
 */
public class LogSystem {
    protected Logger LOGGER;

    public LogSystem() {
    }

    public LogSystem(Class classObj){
        this.LOGGER = Logger.getLogger(classObj);
    }
   
    
    protected void setLogger(){
        this.LOGGER = Logger.getLogger(this.getClass());
    }
    
    public Logger getLogger(){
        return LOGGER;
    }
}
