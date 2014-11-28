/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalstorage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MahmoodKhalid
 */
@Entity
@Table(name = "DETAILED_DELIVERY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailedDelivery.findAll", query = "SELECT d FROM DetailedDelivery d"),
    @NamedQuery(name = "DetailedDelivery.findByDeliveryId", query = "SELECT d FROM DetailedDelivery d WHERE d.detailedDeliveryPK.deliveryId = :deliveryId"),
    @NamedQuery(name = "DetailedDelivery.findByItemId", query = "SELECT d FROM DetailedDelivery d WHERE d.detailedDeliveryPK.itemId = :itemId"),
    @NamedQuery(name = "DetailedDelivery.findByDeliveredQuantity", query = "SELECT d FROM DetailedDelivery d WHERE d.deliveredQuantity = :deliveredQuantity")})
public class DetailedDelivery implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailedDeliveryPK detailedDeliveryPK;
    @Basic(optional = false)
    @Column(name = "DELIVERED_QUANTITY")
    private int deliveredQuantity;
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;
    @JoinColumn(name = "DELIVERY_ID", referencedColumnName = "DELIVERY_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DeliveryForm deliveryForm;

    public DetailedDelivery() {
    }

    public DetailedDelivery(DetailedDeliveryPK detailedDeliveryPK) {
        this.detailedDeliveryPK = detailedDeliveryPK;
    }

    public DetailedDelivery(DetailedDeliveryPK detailedDeliveryPK, int deliveredQuantity) {
        this.detailedDeliveryPK = detailedDeliveryPK;
        this.deliveredQuantity = deliveredQuantity;
    }

    public DetailedDelivery(int deliveryId, int itemId) {
        this.detailedDeliveryPK = new DetailedDeliveryPK(deliveryId, itemId);
    }

    public DetailedDeliveryPK getDetailedDeliveryPK() {
        return detailedDeliveryPK;
    }

    public void setDetailedDeliveryPK(DetailedDeliveryPK detailedDeliveryPK) {
        this.detailedDeliveryPK = detailedDeliveryPK;
    }

    public int getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public DeliveryForm getDeliveryForm() {
        return deliveryForm;
    }

    public void setDeliveryForm(DeliveryForm deliveryForm) {
        this.deliveryForm = deliveryForm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailedDeliveryPK != null ? detailedDeliveryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedDelivery)) {
            return false;
        }
        DetailedDelivery other = (DetailedDelivery) object;
        if ((this.detailedDeliveryPK == null && other.detailedDeliveryPK != null) || (this.detailedDeliveryPK != null && !this.detailedDeliveryPK.equals(other.detailedDeliveryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospitalstorage.DetailedDelivery[ detailedDeliveryPK=" + detailedDeliveryPK + " ]";
    }
    
}
