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
public class Page implements Serializable {

    private int id;
    private String name;
    private int parent;
    private String icon;
    private String path;
    private int status;
    
    public Page() {
    }

    public Page(int id, String name, int parent, String icon, String path, int status) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.icon = icon;
        this.path = path;
        this.status = status;
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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String toString() {
        return "{\"data\":{" +
                "\"id\":" + id +
                "\"name\":\"" + name + "\"" +
                "\"parent\":" + parent +
                "\"icon\":\"" + icon + "\"" +
                "\"path\":\"" + path + "\"" +
                "\"status\":" + status +"}}";
    }

}
