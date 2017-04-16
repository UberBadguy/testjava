/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.util.Date;

/**
 *
 * @author Badguy
 */
public class Employee {
    private int id;
    private int rut;
    private String dv;
    private String name;
    private String last_name;
    private Date birth;
    private String gender;
    private int building_site_id;
    private int status;

    public Employee() {
    }

    public Employee(int id, int rut, String dv, String name, String last_name, Date birth, String gender, int building_site_id, int status) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.name = name;
        this.last_name = last_name;
        this.birth = birth;
        this.gender = gender;
        this.building_site_id = building_site_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBuilding_site_id() {
        return building_site_id;
    }

    public void setBuilding_site_id(int building_site_id) {
        this.building_site_id = building_site_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String toString() {
        return "{\"data\":{" +
                "\"id\":" + id +
                ",\"rut\":" + rut +
                ",\"dv\":\"" + dv + "\"" +
                ",\"name\":\"" + name + "\"" +
                ",\"last_name\":\"" + last_name + "\"" +
                ",\"birth\":\"" + birth + "\"" +
                ",\"gender\":\"" + gender + "\"" +
                ",\"building_site_id\":" + building_site_id +
                ",\"status\":" + status +"}}";
    }
    
}
