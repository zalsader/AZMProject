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
@Table(name = "RECEIVING_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceivingForm.findAll", query = "SELECT r FROM ReceivingForm r"),
    @NamedQuery(name = "ReceivingForm.findByReceivingId", query = "SELECT r FROM ReceivingForm r WHERE r.receivingId = :receivingId"),
    @NamedQuery(name = "ReceivingForm.findByReceivingDate", query = "SELECT r FROM ReceivingForm r WHERE r.receivingDate = :receivingDate")})
public class ReceivingForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RECEIVING_ID")
    private Integer receivingId;
    @Basic(optional = false)
    @Column(name = "RECEIVING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivingDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivingForm")
    private Collection<DetailedReceivingForm> detailedReceivingFormCollection;
    @JoinColumn(name = "BUY_ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private BuyOrder buyOrderId;

    public ReceivingForm() {
    }

    public ReceivingForm(Integer receivingId) {
        this.receivingId = receivingId;
    }

    public ReceivingForm(Integer receivingId, Date receivingDate) {
        this.receivingId = receivingId;
        this.receivingDate = receivingDate;
    }

    public Integer getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(Integer receivingId) {
        this.receivingId = receivingId;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    @XmlTransient
    public Collection<DetailedReceivingForm> getDetailedReceivingFormCollection() {
        return detailedReceivingFormCollection;
    }

    public void setDetailedReceivingFormCollection(Collection<DetailedReceivingForm> detailedReceivingFormCollection) {
        this.detailedReceivingFormCollection = detailedReceivingFormCollection;
    }

    public BuyOrder getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(BuyOrder buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receivingId != null ? receivingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceivingForm)) {
            return false;
        }
        ReceivingForm other = (ReceivingForm) object;
        if ((this.receivingId == null && other.receivingId != null) || (this.receivingId != null && !this.receivingId.equals(other.receivingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospitalstorage.ReceivingForm[ receivingId=" + receivingId + " ]";
    }
    
}
