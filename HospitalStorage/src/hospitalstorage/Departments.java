/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalstorage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MahmoodKhalid
 */
@Entity
@Table(name = "DEPARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d"),
    @NamedQuery(name = "Departments.findByDeptId", query = "SELECT d FROM Departments d WHERE d.deptId = :deptId"),
    @NamedQuery(name = "Departments.findByDeptName", query = "SELECT d FROM Departments d WHERE d.deptName = :deptName"),
    @NamedQuery(name = "Departments.findByDeptMngr", query = "SELECT d FROM Departments d WHERE d.deptMngr = :deptMngr")})
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPT_ID")
    private Integer deptId;
    @Basic(optional = false)
    @Column(name = "DEPT_NAME")
    private String deptName;
    @Column(name = "DEPT_MNGR")
    private String deptMngr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
    private Collection<RequestOfItems> requestOfItemsCollection;

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

    public String getDeptMngr() {
        return deptMngr;
    }

    public void setDeptMngr(String deptMngr) {
        this.deptMngr = deptMngr;
    }

    @XmlTransient
    public Collection<RequestOfItems> getRequestOfItemsCollection() {
        return requestOfItemsCollection;
    }

    public void setRequestOfItemsCollection(Collection<RequestOfItems> requestOfItemsCollection) {
        this.requestOfItemsCollection = requestOfItemsCollection;
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
        return "hospitalstorage.Departments[ deptId=" + deptId + " ]";
    }
    
}
