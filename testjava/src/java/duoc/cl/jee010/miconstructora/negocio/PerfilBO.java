/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.persistencia.PerfilDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PerfilBO {
    private PerfilDAO objPerfilDAO;

    public PerfilBO() {
        this.objPerfilDAO= new PerfilDAO();
    }
    
    public List<Profile> getAllPerfil(){
        return this.objPerfilDAO.readElementos();
    }
            
            
    
}
