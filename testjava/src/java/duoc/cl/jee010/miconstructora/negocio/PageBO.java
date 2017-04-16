/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.persistencia.PageDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PageBO {
    private PageDAO objPageDAO;

    public PageBO() {
        this.objPageDAO= new PageDAO();
    }
    
    public List<Page>getAllPages(){
        return this.objPageDAO.readElements();
    }
    
    public boolean addPage(Page objPage){
        return this.objPageDAO.addElement(objPage);
    }
    
    public boolean deletePage(int codigo){
        return this.objPageDAO.deleteElement(codigo);
    }
    
    public boolean updatePage(Page objPage){
        return this.objPageDAO.updateElement(objPage);
    }
    
    public Page getPage(int codigo){
        return this.objPageDAO.getElement(codigo);
    }
    
    public List<Page>getAllAvailableParents(){
        return this.objPageDAO.getAllAvailableParents();
    }
    
    public List<Page>listadoMenuPorPerfil(int perfil){
        return this.objPageDAO.listPageByProfile(perfil);
    }
    
    
    
}
