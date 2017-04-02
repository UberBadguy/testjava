/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.persistencia.MenuDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class MenuBO {
    private MenuDAO objMenuDAO;

    public MenuBO() {
        this.objMenuDAO= new MenuDAO();
    }
    
    public List<Page>listadoMenuPorUsuario(int perfil){
        return this.objMenuDAO.listadoMenuPorPerfil(perfil);
    }
    
}
