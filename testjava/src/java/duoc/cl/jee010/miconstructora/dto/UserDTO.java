/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Profile;
import duoc.cl.jee010.miconstructora.entidades.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UserDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private User user;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
