/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalstorage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MahmoodKhalid
 */
@Embeddable
public class DetailedReceivingFormPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "RECEIVING_ID")
    private int receivingId;
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private int itemId;

    public DetailedReceivingFormPK() {
    }

    public DetailedReceivingFormPK(int receivingId, int itemId) {
        this.receivingId = receivingId;
        this.itemId = itemId;
    }

    public int getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(int receivingId) {
        this.receivingId = receivingId;
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
        hash += (int) receivingId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedReceivingFormPK)) {
            return false;
        }
        DetailedReceivingFormPK other = (DetailedReceivingFormPK) object;
        if (this.receivingId != other.receivingId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospitalstorage.DetailedReceivingFormPK[ receivingId=" + receivingId + ", itemId=" + itemId + " ]";
    }
    
}
