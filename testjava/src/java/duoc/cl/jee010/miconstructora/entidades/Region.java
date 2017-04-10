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
public class Region {
    
    private int id;
    private String name;
    private String ordinal;

    public Region() {
    }

    public Region(int id, String name, String ordinal) {
        this.id = id;
        this.name = name;
        this.ordinal = ordinal;
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

    public String getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }
    
    
    
}
