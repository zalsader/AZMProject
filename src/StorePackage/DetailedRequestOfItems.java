/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StorePackage;

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
@Table(name = "DETAILED_REQUEST_OF_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailedRequestOfItems.findAll", query = "SELECT d FROM DetailedRequestOfItems d"),
    @NamedQuery(name = "DetailedRequestOfItems.findByRequestId", query = "SELECT d FROM DetailedRequestOfItems d WHERE d.detailedRequestOfItemsPK.requestId = :requestId"),
    @NamedQuery(name = "DetailedRequestOfItems.findByItemId", query = "SELECT d FROM DetailedRequestOfItems d WHERE d.detailedRequestOfItemsPK.itemId = :itemId"),
    @NamedQuery(name = "DetailedRequestOfItems.findByRequestedQuantity", query = "SELECT d FROM DetailedRequestOfItems d WHERE d.requestedQuantity = :requestedQuantity")})
public class DetailedRequestOfItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailedRequestOfItemsPK detailedRequestOfItemsPK;
    @Basic(optional = false)
    @Column(name = "REQUESTED_QUANTITY")
    private int requestedQuantity;
    @JoinColumn(name = "REQUEST_ID", referencedColumnName = "REQUEST_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequestOfItems requestOfItems;
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;

    public DetailedRequestOfItems() {
    }

    public DetailedRequestOfItems(DetailedRequestOfItemsPK detailedRequestOfItemsPK) {
        this.detailedRequestOfItemsPK = detailedRequestOfItemsPK;
    }

    public DetailedRequestOfItems(DetailedRequestOfItemsPK detailedRequestOfItemsPK, int requestedQuantity) {
        this.detailedRequestOfItemsPK = detailedRequestOfItemsPK;
        this.requestedQuantity = requestedQuantity;
    }

    public DetailedRequestOfItems(int requestId, int itemId) {
        this.detailedRequestOfItemsPK = new DetailedRequestOfItemsPK(requestId, itemId);
    }

    public DetailedRequestOfItemsPK getDetailedRequestOfItemsPK() {
        return detailedRequestOfItemsPK;
    }

    public void setDetailedRequestOfItemsPK(DetailedRequestOfItemsPK detailedRequestOfItemsPK) {
        this.detailedRequestOfItemsPK = detailedRequestOfItemsPK;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public RequestOfItems getRequestOfItems() {
        return requestOfItems;
    }

    public void setRequestOfItems(RequestOfItems requestOfItems) {
        this.requestOfItems = requestOfItems;
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
        hash += (detailedRequestOfItemsPK != null ? detailedRequestOfItemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedRequestOfItems)) {
            return false;
        }
        DetailedRequestOfItems other = (DetailedRequestOfItems) object;
        if ((this.detailedRequestOfItemsPK == null && other.detailedRequestOfItemsPK != null) || (this.detailedRequestOfItemsPK != null && !this.detailedRequestOfItemsPK.equals(other.detailedRequestOfItemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedRequestOfItems[ detailedRequestOfItemsPK=" + detailedRequestOfItemsPK + " ]";
    }
    
}
