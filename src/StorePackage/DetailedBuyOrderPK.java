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
public class DetailedBuyOrderPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private int orderId;
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private int itemId;

    public DetailedBuyOrderPK() {
    }

    public DetailedBuyOrderPK(int orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
        hash += (int) orderId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedBuyOrderPK)) {
            return false;
        }
        DetailedBuyOrderPK other = (DetailedBuyOrderPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedBuyOrderPK[ orderId=" + orderId + ", itemId=" + itemId + " ]";
    }
    
}
