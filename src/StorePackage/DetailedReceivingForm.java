/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StorePackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MahmoodKhalid
 */
@Entity
@Table(name = "DETAILED_RECEIVING_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailedReceivingForm.findAll", query = "SELECT d FROM DetailedReceivingForm d"),
    @NamedQuery(name = "DetailedReceivingForm.findByReceivingId", query = "SELECT d FROM DetailedReceivingForm d WHERE d.detailedReceivingFormPK.receivingId = :receivingId"),
    @NamedQuery(name = "DetailedReceivingForm.findByItemId", query = "SELECT d FROM DetailedReceivingForm d WHERE d.detailedReceivingFormPK.itemId = :itemId"),
    @NamedQuery(name = "DetailedReceivingForm.findByReceivingQuantity", query = "SELECT d FROM DetailedReceivingForm d WHERE d.receivingQuantity = :receivingQuantity"),
    @NamedQuery(name = "DetailedReceivingForm.findByExpirationDate", query = "SELECT d FROM DetailedReceivingForm d WHERE d.expirationDate = :expirationDate")})
public class DetailedReceivingForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailedReceivingFormPK detailedReceivingFormPK;
    @Basic(optional = false)
    @Column(name = "RECEIVING_QUANTITY")
    private int receivingQuantity;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @JoinColumn(name = "RECEIVING_ID", referencedColumnName = "RECEIVING_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReceivingForm receivingForm;
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;

    public DetailedReceivingForm() {
    }

    public DetailedReceivingForm(DetailedReceivingFormPK detailedReceivingFormPK) {
        this.detailedReceivingFormPK = detailedReceivingFormPK;
    }

    public DetailedReceivingForm(DetailedReceivingFormPK detailedReceivingFormPK, int receivingQuantity) {
        this.detailedReceivingFormPK = detailedReceivingFormPK;
        this.receivingQuantity = receivingQuantity;
    }

    public DetailedReceivingForm(int receivingId, int itemId) {
        this.detailedReceivingFormPK = new DetailedReceivingFormPK(receivingId, itemId);
    }

    public DetailedReceivingFormPK getDetailedReceivingFormPK() {
        return detailedReceivingFormPK;
    }

    public void setDetailedReceivingFormPK(DetailedReceivingFormPK detailedReceivingFormPK) {
        this.detailedReceivingFormPK = detailedReceivingFormPK;
    }

    public int getReceivingQuantity() {
        return receivingQuantity;
    }

    public void setReceivingQuantity(int receivingQuantity) {
        this.receivingQuantity = receivingQuantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ReceivingForm getReceivingForm() {
        return receivingForm;
    }

    public void setReceivingForm(ReceivingForm receivingForm) {
        this.receivingForm = receivingForm;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailedReceivingFormPK != null ? detailedReceivingFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedReceivingForm)) {
            return false;
        }
        DetailedReceivingForm other = (DetailedReceivingForm) object;
        if ((this.detailedReceivingFormPK == null && other.detailedReceivingFormPK != null) || (this.detailedReceivingFormPK != null && !this.detailedReceivingFormPK.equals(other.detailedReceivingFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedReceivingForm[ detailedReceivingFormPK=" + detailedReceivingFormPK + " ]";
    }
    
}
