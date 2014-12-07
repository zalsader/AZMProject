/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "DELIVERY_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryForm.findAll", query = "SELECT d FROM DeliveryForm d"),
    @NamedQuery(name = "DeliveryForm.findByDeliveryId", query = "SELECT d FROM DeliveryForm d WHERE d.deliveryId = :deliveryId"),
    @NamedQuery(name = "DeliveryForm.findConfirmedByDeptId", query = "SELECT d FROM DeliveryForm d WHERE d.deptId.deptId = :deptId and d.confirmed = :confirmed"),
    @NamedQuery(name = "DeliveryForm.findByDeptId", query = "SELECT d FROM DeliveryForm d WHERE d.deptId = :deptId"),
    @NamedQuery(name = "DeliveryForm.findByDeliveryDate", query = "SELECT d FROM DeliveryForm d WHERE d.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "DeliveryForm.findByConfirmed", query = "SELECT d FROM DeliveryForm d WHERE d.confirmed = :confirmed")})
public class DeliveryForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="delivery_form_pk_seq")
    @SequenceGenerator(name="delivery_form_pk_seq", sequenceName="delivery_form_pk_seq", allocationSize=1)
    @Column(name = "DELIVERY_ID")
    private Integer deliveryId;
    @Basic(optional = false)
    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Basic(optional = false)
    @Column(name = "CONFIRMED")
    private Character confirmed;
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    @ManyToOne(optional = false)
    private Departments deptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryForm")
    private Collection<DetailedDelivery> detailedDeliveryCollection;

    public DeliveryForm() {
    }

    public DeliveryForm(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public DeliveryForm(Integer deliveryId, Date deliveryDate, Character confirmed) {
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.confirmed = confirmed;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Character getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Character confirmed) {
        this.confirmed = confirmed;
    }

    public Departments getDeptId() {
        return deptId;
    }

    public void setDeptId(Departments deptId) {
        this.deptId = deptId;
    }

    @XmlTransient
    public Collection<DetailedDelivery> getDetailedDeliveryCollection() {
        return detailedDeliveryCollection;
    }

    public void setDetailedDeliveryCollection(Collection<DetailedDelivery> detailedDeliveryCollection) {
        this.detailedDeliveryCollection = detailedDeliveryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryId != null ? deliveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryForm)) {
            return false;
        }
        DeliveryForm other = (DeliveryForm) object;
        if ((this.deliveryId == null && other.deliveryId != null) || (this.deliveryId != null && !this.deliveryId.equals(other.deliveryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<html>"+(confirmed=='N'?"<font color=red>New </font>":"") + deliveryId + ": "+deliveryDate+"</html>";
    }
    
}
