/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Page;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UserProfilePagesDTO implements Serializable{
    private int user_id;
    private String user_login;
    private String user_email;
    private String employee_name;
    private String profile_name;
    private List<Page> pages;

    public UserProfilePagesDTO() {
    }

    public UserProfilePagesDTO(int user_id, String user_login, String user_email, String employee_name, String profile_name, List<Page> pages) {
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_email = user_email;
        this.employee_name = employee_name;
        this.profile_name = profile_name;
        this.pages = pages;
    }

    public UserProfilePagesDTO(int user_id, String user_login, String user_email, String employee_name, String profile_name) {
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_email = user_email;
        this.employee_name = employee_name;
        this.profile_name = profile_name;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
    
    
}
