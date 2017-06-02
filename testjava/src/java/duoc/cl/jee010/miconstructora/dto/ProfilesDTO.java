/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Profile;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class ProfilesDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Profile> profiles;
    private Profile profile;

    public ProfilesDTO() {
    }

    public ProfilesDTO(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public ProfilesDTO(Profile profile) {
        this.profile = profile;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "ProfilesDTO{" + "profile=" + profile + '}';
    }
    
    
}
