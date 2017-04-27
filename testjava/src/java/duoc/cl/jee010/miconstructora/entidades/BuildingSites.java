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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "building_sites", catalog = "constructora", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuildingSites.findAll", query = "SELECT b FROM BuildingSites b"),
    @NamedQuery(name = "BuildingSites.findById", query = "SELECT b FROM BuildingSites b WHERE b.id = :id"),
    @NamedQuery(name = "BuildingSites.findByName", query = "SELECT b FROM BuildingSites b WHERE b.name = :name"),
    @NamedQuery(name = "BuildingSites.findByAddress", query = "SELECT b FROM BuildingSites b WHERE b.address = :address"),
    @NamedQuery(name = "BuildingSites.findByDistrictId", query = "SELECT b FROM BuildingSites b WHERE b.districtId = :districtId"),
    @NamedQuery(name = "BuildingSites.findByStatus", query = "SELECT b FROM BuildingSites b WHERE b.status = :status")})
public class BuildingSites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "address", nullable = false, length = 150)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "district_id", nullable = false)
    private int districtId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    public BuildingSites() {
    }

    public BuildingSites(Integer id) {
        this.id = id;
    }

    public BuildingSites(Integer id, String name, String address, int districtId, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.districtId = districtId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof BuildingSites)) {
            return false;
        }
        BuildingSites other = (BuildingSites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.jee010.miconstructora.entidades.BuildingSites[ id=" + id + " ]";
    }
    
}
