/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.persistencia.UserDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UsuarioBO {
    
    private final UserDAO objUsuarioDAO;
    
    public UsuarioBO() {
        this.objUsuarioDAO=new UserDAO();
    }
    
    public User validaUsuario(String login,String pass){
        return this.objUsuarioDAO.authenticate(login, pass);
    }
    
    public List<User>getAllUser(){
        return this.objUsuarioDAO.readElements();
    }
    
    public boolean addUsuario(User objUsuario){
        return this.objUsuarioDAO.addElement(objUsuario);
    }
    
    public boolean deleteUsuario(int codigo){
        return this.objUsuarioDAO.deleteElement(codigo);
    }
    
    public boolean update(User objUsuario){
        return this.objUsuarioDAO.updateElement(objUsuario);
    }
    
    public User getUser(int codigo){
        return this.objUsuarioDAO.getElement(codigo);
    }
    
}
