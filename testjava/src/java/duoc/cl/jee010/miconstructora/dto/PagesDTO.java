/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.entidades.ProfilesPage;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class PagesDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<ProfilesPage> pages;
    private Page page;

    public PagesDTO() {
    }

    public PagesDTO(Page page) {
        this.page = page;
    }

    public PagesDTO(List<ProfilesPage> pages) {
        this.pages = pages;
    }

    public List<ProfilesPage> getPages() {
        return pages;
    }

    public void setPages(List<ProfilesPage> pages) {
        this.pages = pages;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "{\"data\":{" +
                "\"id\":" + this.page.getId() +
                ",\"name\":\"" + this.page.getName() + "\"" +
                ",\"icon\":\"" + this.page.getIcon() + "\"" +
                ",\"path\":\"" + this.page.getPath() + "\"" +
                ",\"parent\":" + this.page.getParent() +
                ",\"status\":" + this.page.getStatus() +"}}";
    }
    
}
