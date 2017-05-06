/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "pages", catalog = "constructora", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p"),
    @NamedQuery(name = "Page.findById", query = "SELECT p FROM Page p WHERE p.id = :id"),
    @NamedQuery(name = "Page.findByName", query = "SELECT p FROM Page p WHERE p.name = :name"),
    @NamedQuery(name = "Page.findByPath", query = "SELECT p FROM Page p WHERE p.path = :path"),
    @NamedQuery(name = "Page.findByIcon", query = "SELECT p FROM Page p WHERE p.icon = :icon"),
    @NamedQuery(name = "Page.findByParent", query = "SELECT p FROM Page p WHERE p.parent = :parent"),
    @NamedQuery(name = "Page.findByStatus", query = "SELECT p FROM Page p WHERE p.status = :status")})
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "path", nullable = false, length = 255)
    private String path;
    @Size(max = 50)
    @Column(name = "icon", length = 50)
    private String icon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parent", nullable = false)
    private int parent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private List<ProfilesPage> profilesPageList;

    public Page() {
    }

    public Page(Integer id) {
        this.id = id;
    }

    public Page(Integer id, String name, String path, int parent, int status) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.parent = parent;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<ProfilesPage> getProfilesPageList() {
        return profilesPageList;
    }

    public void setProfilesPageList(List<ProfilesPage> profilesPageList) {
        this.profilesPageList = profilesPageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.jee010.miconstructora.entidades.Page[ id=" + id + " ]";
    }
    
}
