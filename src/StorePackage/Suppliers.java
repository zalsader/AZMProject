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
@Table(name = "SUPPLIERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findBySupplierId", query = "SELECT s FROM Suppliers s WHERE s.supplierId = :supplierId"),
    @NamedQuery(name = "Suppliers.findBySupplierName", query = "SELECT s FROM Suppliers s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "Suppliers.findBySupplierAddress", query = "SELECT s FROM Suppliers s WHERE s.supplierAddress = :supplierAddress"),
    @NamedQuery(name = "Suppliers.findByPhoneNo", query = "SELECT s FROM Suppliers s WHERE s.phoneNo = :phoneNo"),
    @NamedQuery(name = "Suppliers.findByFaxNo", query = "SELECT s FROM Suppliers s WHERE s.faxNo = :faxNo")})
public class Suppliers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    @Basic(optional = false)
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Basic(optional = false)
    @Column(name = "SUPPLIER_ADDRESS")
    private String supplierAddress;
    @Basic(optional = false)
    @Column(name = "PHONE_NO")
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "FAX_NO")
    private String faxNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<BuyOrder> buyOrderCollection;

    public Suppliers() {
    }

    public Suppliers(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Suppliers(Integer supplierId, String supplierName, String supplierAddress, String phoneNo, String faxNo) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.phoneNo = phoneNo;
        this.faxNo = faxNo;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    @XmlTransient
    public Collection<BuyOrder> getBuyOrderCollection() {
        return buyOrderCollection;
    }

    public void setBuyOrderCollection(Collection<BuyOrder> buyOrderCollection) {
        this.buyOrderCollection = buyOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.Suppliers[ supplierId=" + supplierId + " ]";
    }
    
}
