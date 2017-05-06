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
public class UserProfileDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private User user;
    private Profile profile;

    public UserProfileDTO() {
    }

    public UserProfileDTO(User user, Profile profile) {
        this.user = user;
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    
}
