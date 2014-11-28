/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalstorage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MahmoodKhalid
 */
@Entity
@Table(name = "REQUEST_OF_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestOfItems.findAll", query = "SELECT r FROM RequestOfItems r"),
    @NamedQuery(name = "RequestOfItems.findByRequestId", query = "SELECT r FROM RequestOfItems r WHERE r.requestId = :requestId"),
    @NamedQuery(name = "RequestOfItems.findByRequestDate", query = "SELECT r FROM RequestOfItems r WHERE r.requestDate = :requestDate")})
public class RequestOfItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REQUEST_ID")
    private Integer requestId;
    @Basic(optional = false)
    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<DeliveryForm> deliveryFormCollection;
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    @ManyToOne(optional = false)
    private Departments deptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestOfItems")
    private Collection<DetailedRequestOfItems> detailedRequestOfItemsCollection;

    public RequestOfItems() {
    }

    public RequestOfItems(Integer requestId) {
        this.requestId = requestId;
    }

    public RequestOfItems(Integer requestId, Date requestDate) {
        this.requestId = requestId;
        this.requestDate = requestDate;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @XmlTransient
    public Collection<DeliveryForm> getDeliveryFormCollection() {
        return deliveryFormCollection;
    }

    public void setDeliveryFormCollection(Collection<DeliveryForm> deliveryFormCollection) {
        this.deliveryFormCollection = deliveryFormCollection;
    }

    public Departments getDeptId() {
        return deptId;
    }

    public void setDeptId(Departments deptId) {
        this.deptId = deptId;
    }

    @XmlTransient
    public Collection<DetailedRequestOfItems> getDetailedRequestOfItemsCollection() {
        return detailedRequestOfItemsCollection;
    }

    public void setDetailedRequestOfItemsCollection(Collection<DetailedRequestOfItems> detailedRequestOfItemsCollection) {
        this.detailedRequestOfItemsCollection = detailedRequestOfItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestOfItems)) {
            return false;
        }
        RequestOfItems other = (RequestOfItems) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospitalstorage.RequestOfItems[ requestId=" + requestId + " ]";
    }
    
}
