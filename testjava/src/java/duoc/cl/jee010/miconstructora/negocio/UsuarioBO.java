/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.User;
import duoc.cl.jee010.miconstructora.dto.UsuarioPerfilDTO;
import duoc.cl.jee010.miconstructora.persistencia.UsuarioDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UsuarioBO {
    
    private final UsuarioDAO objUsuarioDAO;
    
    public UsuarioBO() {
        this.objUsuarioDAO=new UsuarioDAO();
    }
    
    public User validaUsuario(String login,String pass){
        return this.objUsuarioDAO.validaIngreso(login, pass);
    }
    
    public List<User>getAllUser(){
        return this.objUsuarioDAO.readElementos();
    }
    
    public List<UsuarioPerfilDTO>getAllUserPerfilDTO(){
        return this.objUsuarioDAO.readUsuariosPerfilDTO();
    }
    
    public boolean addUsuario(User objUsuario){
        return this.objUsuarioDAO.addElemento(objUsuario);
    }
    
    public boolean deleteUsuario(int codigo){
        return this.objUsuarioDAO.deleteElemento(codigo);
    }
    
    public boolean update(User objUsuario){
        return this.objUsuarioDAO.updateElemento(objUsuario);
    }
    
    public User buscaUsuarioXcodigo(int codigo){
        return this.objUsuarioDAO.buscaUsuarioXcodigo(codigo);
    }
    
}
