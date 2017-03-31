/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.negocio;

import duoc.cl.jee010.unidad1.entidades.Usuario;
import duoc.cl.jee010.unidad1.dto.UsuarioPerfilDTO;
import duoc.cl.jee010.unidad1.persistencia.UsuarioDAO;
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
    
    public Usuario validaUsuario(String login,String pass){
        return this.objUsuarioDAO.validaIngreso(login, pass);
    }
    
    public List<Usuario>getAllUser(){
        return this.objUsuarioDAO.readElementos();
    }
    
    public List<UsuarioPerfilDTO>getAllUserPerfilDTO(){
        return this.objUsuarioDAO.readUsuariosPerfilDTO();
    }
    
    public boolean addUsuario(Usuario objUsuario){
        return this.objUsuarioDAO.addElemento(objUsuario);
    }
    
    public boolean deleteUsuario(int codigo){
        return this.objUsuarioDAO.deleteElemento(codigo);
    }
    
    public boolean update(Usuario objUsuario){
        return this.objUsuarioDAO.updateElemento(objUsuario);
    }
    
    public Usuario buscaUsuarioXcodigo(int codigo){
        return this.objUsuarioDAO.buscaUsuarioXcodigo(codigo);
    }
    
}
