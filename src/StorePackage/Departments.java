/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "DEPARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d"),
    @NamedQuery(name = "Departments.findByDeptId", query = "SELECT d FROM Departments d WHERE d.deptId = :deptId"),
    @NamedQuery(name = "Departments.findByDeptName", query = "SELECT d FROM Departments d WHERE d.deptName = :deptName")})
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="departments_pk_seq")
    @SequenceGenerator(name="departments_pk_seq", sequenceName="departments_pk_seq", allocationSize=1)
    @Column(name = "DEPT_ID")
    private Integer deptId;
    @Basic(optional = false)
    @Column(name = "DEPT_NAME")
    private String deptName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
    private Collection<DeliveryForm> deliveryFormCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
    private Collection<RequestOfItems> requestOfItemsCollection;
    @JoinColumn(name = "DEPT_MNGR_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private Users deptMngrId;
    @OneToMany(mappedBy = "deptId")
    private Collection<NeededItemsPerDept> neededItemsPerDeptCollection;
    @OneToMany(mappedBy = "deptId")
    private Collection<Users> usersCollection;

    public Departments() {
    }

    public Departments(Integer deptId) {
        this.deptId = deptId;
    }

    public Departments(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @XmlTransient
    public Collection<DeliveryForm> getDeliveryFormCollection() {
        return deliveryFormCollection;
    }

    public void setDeliveryFormCollection(Collection<DeliveryForm> deliveryFormCollection) {
        this.deliveryFormCollection = deliveryFormCollection;
    }

    @XmlTransient
    public Collection<RequestOfItems> getRequestOfItemsCollection() {
        return requestOfItemsCollection;
    }

    public void setRequestOfItemsCollection(Collection<RequestOfItems> requestOfItemsCollection) {
        this.requestOfItemsCollection = requestOfItemsCollection;
    }

    public Users getDeptMngrId() {
        return deptMngrId;
    }

    public void setDeptMngrId(Users deptMngrId) {
        this.deptMngrId = deptMngrId;
    }

    @XmlTransient
    public Collection<NeededItemsPerDept> getNeededItemsPerDeptCollection() {
        return neededItemsPerDeptCollection;
    }

    public void setNeededItemsPerDeptCollection(Collection<NeededItemsPerDept> neededItemsPerDeptCollection) {
        this.neededItemsPerDeptCollection = neededItemsPerDeptCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.Departments[ deptId=" + deptId + " ]";
    }
    
}
