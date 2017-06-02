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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "building_sites", catalog = "constructora", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuildingSite.findAll", query = "SELECT b FROM BuildingSite b"),
    @NamedQuery(name = "BuildingSite.findById", query = "SELECT b FROM BuildingSite b WHERE b.id = :id"),
    @NamedQuery(name = "BuildingSite.findByName", query = "SELECT b FROM BuildingSite b WHERE b.name = :name"),
    @NamedQuery(name = "BuildingSite.findByAddress", query = "SELECT b FROM BuildingSite b WHERE b.address = :address"),
    @NamedQuery(name = "BuildingSite.findByStatus", query = "SELECT b FROM BuildingSite b WHERE b.status = :status"),
    @NamedQuery(name = "BuildingSite.update", query = "UPDATE BuildingSite b WHERE b.status = :status")})
public class BuildingSite implements Serializable {

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
    @Column(name = "status", nullable = false)
    private int status;
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private District districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buildingSiteId")
    private List<Employee> employeeList;

    public BuildingSite() {
    }

    public BuildingSite(Integer id) {
        this.id = id;
    }

    public BuildingSite(Integer id, String name, String address, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof BuildingSite)) {
            return false;
        }
        BuildingSite other = (BuildingSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.jee010.miconstructora.entidades.BuildingSite[ id=" + id + " ]";
    }
    
}
