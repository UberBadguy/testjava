/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.negocio;

import duoc.cl.jee010.unidad1.entidades.Perfil;
import duoc.cl.jee010.unidad1.persistencia.PerfilDAO;
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
    
    public List<Perfil> getAllPerfil(){
        return this.objPerfilDAO.readElementos();
    }
            
            
    
}
