/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.persistencia.ProfileDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ProfileBO {
    
    private final ProfileDAO objProfileDAO;
    
    public ProfileBO() {
        this.objProfileDAO=new ProfileDAO();
    }
    
    public List<Profile>getAllProfile(){
        return this.objProfileDAO.readElements();
    }
    
    public boolean addUser(Profile objProfile){
        return this.objProfileDAO.addElement(objProfile);
    }
    
    public boolean deleteUser(int codigo){
        return this.objProfileDAO.deleteElement(codigo);
    }
    
    public boolean updateUser(Profile objUser){
        return this.objProfileDAO.updateElement(objUser);
    }
    
    public Profile getProfile(int id){
        return this.objProfileDAO.getElement(id);
    }
    
}
