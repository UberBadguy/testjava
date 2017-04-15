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
public class BuildingSite implements Serializable {

    private int id;
    private String name;
    private String address;
    private int district_id;
    private int status;
    
    public BuildingSite() {
    }

    public BuildingSite(int id, String name, String address, int district_id, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.district_id = district_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                ",\"name\":\"" + name + "\"" +
                ",\"address\":\"" + address + "\"" +
                ",\"district_id\":\"" + district_id + "\"" +
                ",\"status\":" + status +"}}";
    }
    
}
