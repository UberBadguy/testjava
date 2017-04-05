/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import duoc.cl.jee010.miconstructora.persistencia.BuildingSiteDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class BuildingSiteBO {
    
    private final BuildingSiteDAO objBuildingSiteDAO;
    
    public BuildingSiteBO() {
        this.objBuildingSiteDAO=new BuildingSiteDAO();
    }
    
    public List<BuildingSite>getAllBuildingSite(){
        return this.objBuildingSiteDAO.readElements();
    }
    
    public boolean addBuildingSite(BuildingSite objBuildingSite){
        return this.objBuildingSiteDAO.addElement(objBuildingSite);
    }
    
    public boolean deleteBuildingSite(int codigo){
        return this.objBuildingSiteDAO.deleteElement(codigo);
    }
    
    public boolean updateBuildingSite(BuildingSite objBuildingSite){
        return this.objBuildingSiteDAO.updateElement(objBuildingSite);
    }
    
    public BuildingSite getBuildingSite(int id){
        return this.objBuildingSiteDAO.getElement(id);
    }
    
}
