/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "employees", catalog = "constructora", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id"),
    @NamedQuery(name = "Employees.findByRut", query = "SELECT e FROM Employees e WHERE e.rut = :rut"),
    @NamedQuery(name = "Employees.findByDv", query = "SELECT e FROM Employees e WHERE e.dv = :dv"),
    @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employees.findByGender", query = "SELECT e FROM Employees e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employees.findByBuildingSiteId", query = "SELECT e FROM Employees e WHERE e.buildingSiteId = :buildingSiteId"),
    @NamedQuery(name = "Employees.findByPaymentMethod", query = "SELECT e FROM Employees e WHERE e.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Employees.findByAccountNumber", query = "SELECT e FROM Employees e WHERE e.accountNumber = :accountNumber"),
    @NamedQuery(name = "Employees.findByBank", query = "SELECT e FROM Employees e WHERE e.bank = :bank"),
    @NamedQuery(name = "Employees.findByValuePerHour", query = "SELECT e FROM Employees e WHERE e.valuePerHour = :valuePerHour"),
    @NamedQuery(name = "Employees.findByStatus", query = "SELECT e FROM Employees e WHERE e.status = :status")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut", nullable = false)
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dv", nullable = false, length = 1)
    private String dv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "building_site_id", nullable = false)
    private int buildingSiteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "payment_method", nullable = false, length = 60)
    private String paymentMethod;
    @Column(name = "account_number")
    private Integer accountNumber;
    @Size(max = 60)
    @Column(name = "bank", length = 60)
    private String bank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value_per_hour", nullable = false)
    private int valuePerHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    public Employees() {
    }

    public Employees(Integer id) {
        this.id = id;
    }

    public Employees(Integer id, int rut, String dv, String name, String lastName, Date birthDate, String gender, int buildingSiteId, String paymentMethod, int valuePerHour, int status) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.buildingSiteId = buildingSiteId;
        this.paymentMethod = paymentMethod;
        this.valuePerHour = valuePerHour;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBuildingSiteId() {
        return buildingSiteId;
    }

    public void setBuildingSiteId(int buildingSiteId) {
        this.buildingSiteId = buildingSiteId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(int valuePerHour) {
        this.valuePerHour = valuePerHour;
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
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.jee010.miconstructora.entidades.Employees[ id=" + id + " ]";
    }
    
}
