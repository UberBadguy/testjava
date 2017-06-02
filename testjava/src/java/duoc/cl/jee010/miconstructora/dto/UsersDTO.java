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
    private User user;

    public UsersDTO() {
    }

    public UsersDTO(List<User> users) {
        this.users = users;
    }

    public UsersDTO(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{\"data\":{" +
                "\"id\":" + this.user.getId() + 
                ",\"login\":\"" + this.user.getLogin() + "\"" +
                ",\"password\":\"" + this.user.getPassword() +"\"" +
                ",\"email\":\"" + this.user.getEmail() +"\"" +
                ",\"profile_id\":" + this.user.getProfileId() +
                ",\"employee_id\":" + this.user.getEmployeeId() +
                ",\"name\":\"" + this.user.getEmployeeId().getName() + "\"" +
                ",\"status\":" + this.user.getStatus() +"}}";
}
    
}
