/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.dto.UserProfilePagesDTO;
import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.persistencia.UserDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UserBO {
    
    private final UserDAO objUsuarioDAO;
    
    public UserBO() {
        this.objUsuarioDAO=new UserDAO();
    }
    
    public UserProfilePagesDTO authenticate(String login,String pass){
        return this.objUsuarioDAO.authenticate(login, pass);
    }
    
    public List<User>getAllUser(){
        return this.objUsuarioDAO.readElements();
    }
    
    public boolean addUser(User objUser){
        return this.objUsuarioDAO.addElement(objUser);
    }
    
    public boolean deleteUser(int codigo){
        return this.objUsuarioDAO.deleteElement(codigo);
    }
    
    public boolean updateUser(User objUser){
        return this.objUsuarioDAO.updateElement(objUser);
    }
    
    public User getUser(int codigo){
        return this.objUsuarioDAO.getElement(codigo);
    }
    
}
