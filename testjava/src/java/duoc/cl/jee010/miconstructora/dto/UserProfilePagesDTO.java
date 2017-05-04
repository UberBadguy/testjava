/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Profiles;
import duoc.cl.jee010.miconstructora.entidades.Users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UserProfilePagesDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Users user;
    private Profiles profile;

    public UserProfilePagesDTO() {
    }

    public UserProfilePagesDTO(Users user, Profiles profile) {
        this.user = user;
        this.profile = profile;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Profiles getProfile() {
        return profile;
    }

    public void setProfile(Profiles profile) {
        this.profile = profile;
    }
    
    
}
