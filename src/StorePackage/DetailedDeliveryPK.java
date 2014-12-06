/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Zuhair
 */
@Embeddable
public class DetailedDeliveryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DELIVERY_ID")
    private int deliveryId;
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private int itemId;

    public DetailedDeliveryPK() {
    }

    public DetailedDeliveryPK(int deliveryId, int itemId) {
        this.deliveryId = deliveryId;
        this.itemId = itemId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) deliveryId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedDeliveryPK)) {
            return false;
        }
        DetailedDeliveryPK other = (DetailedDeliveryPK) object;
        if (this.deliveryId != other.deliveryId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedDeliveryPK[ deliveryId=" + deliveryId + ", itemId=" + itemId + " ]";
    }
    
}
