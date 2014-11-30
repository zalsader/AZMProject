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
 * @author MahmoodKhalid
 */
@Embeddable
public class DetailedRequestOfItemsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REQUEST_ID")
    private int requestId;
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private int itemId;

    public DetailedRequestOfItemsPK() {
    }

    public DetailedRequestOfItemsPK(int requestId, int itemId) {
        this.requestId = requestId;
        this.itemId = itemId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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
        hash += (int) requestId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedRequestOfItemsPK)) {
            return false;
        }
        DetailedRequestOfItemsPK other = (DetailedRequestOfItemsPK) object;
        if (this.requestId != other.requestId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedRequestOfItemsPK[ requestId=" + requestId + ", itemId=" + itemId + " ]";
    }
    
}
