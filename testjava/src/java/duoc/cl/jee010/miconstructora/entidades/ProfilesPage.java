/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "profiles_pages", catalog = "constructora", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfilesPage.findByProfile", query = "SELECT p FROM ProfilesPage p WHERE p.profileId = :id"),
    @NamedQuery(name = "ProfilesPage.findAll", query = "SELECT p FROM ProfilesPage p"),
    @NamedQuery(name = "ProfilesPage.findById", query = "SELECT p FROM ProfilesPage p WHERE p.id = :id")})
public class ProfilesPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Profile profileId;
    @JoinColumn(name = "page_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Page pageId;

    public ProfilesPage() {
    }

    public ProfilesPage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
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
        if (!(object instanceof ProfilesPage)) {
            return false;
        }
        ProfilesPage other = (ProfilesPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.jee010.miconstructora.entidades.ProfilesPage[ id=" + id + " ]";
    }
    
}
