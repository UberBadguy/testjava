/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.io.Serializable;

/**
 *
 * @author amontess
 */
public class User implements Serializable{
    private int id;
    private String login;
    private String password;
    private String email;
    private int profile_id;
    private int employee_id;
    private int status;
    private String profile_name;

    public User() {
    }

    public User(int id, String login, String password, String email, int profile_id, int employee_id, int status, String profile_name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.profile_id = profile_id;
        this.employee_id = employee_id;
        this.status = status;
        this.profile_name = profile_name;
    }
    
    public User(int id, String login, String password, String email, int profile_id, int employee_id, int status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.profile_id = profile_id;
        this.employee_id = employee_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }
    
    public String toString() {
        return "{\"data\":{" +
                "\"id\":" + id + 
                ",\"login\":\"" + login + "\"" +
                ",\"password\":\"" + password +"\"" +
                ",\"email\":\"" + email +"\"" +
                ",\"profile_id\":" + profile_id +
                ",\"employee_id\":" + employee_id +
                ",\"status\":" + status +"}}";
    }
}
