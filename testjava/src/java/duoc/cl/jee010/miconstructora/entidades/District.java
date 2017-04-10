/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

/**
 *
 * @author Badguy
 */
public class District {
    
    private int id;
    private String name;
    private int province_id;

    public District() {
    }

    public District(int id, String name, int province_id) {
        this.id = id;
        this.name = name;
        this.province_id = province_id;
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

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }
    
    
    
    
}
