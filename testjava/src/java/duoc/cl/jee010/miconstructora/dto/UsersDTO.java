/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class UsersDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<User> users;

    public UsersDTO() {
    }

    public UsersDTO(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
