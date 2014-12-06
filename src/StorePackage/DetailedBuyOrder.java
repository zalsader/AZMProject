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
 * @author Zuhair
 */
@Entity
@Table(name = "DETAILED_BUY_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailedBuyOrder.findAll", query = "SELECT d FROM DetailedBuyOrder d"),
    @NamedQuery(name = "DetailedBuyOrder.findByOrderId", query = "SELECT d FROM DetailedBuyOrder d WHERE d.detailedBuyOrderPK.orderId = :orderId"),
    @NamedQuery(name = "DetailedBuyOrder.findByOrderIdAndItemId", query = "SELECT d FROM DetailedBuyOrder d WHERE d.detailedBuyOrderPK.orderId = :orderId and d.detailedBuyOrderPK.itemId = :itemId"),
    @NamedQuery(name = "DetailedBuyOrder.findByItemId", query = "SELECT d FROM DetailedBuyOrder d WHERE d.detailedBuyOrderPK.itemId = :itemId"),
    @NamedQuery(name = "DetailedBuyOrder.findByBuyQuantity", query = "SELECT d FROM DetailedBuyOrder d WHERE d.buyQuantity = :buyQuantity"),
    @NamedQuery(name = "DetailedBuyOrder.findByUnitPrice", query = "SELECT d FROM DetailedBuyOrder d WHERE d.unitPrice = :unitPrice")})
public class DetailedBuyOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailedBuyOrderPK detailedBuyOrderPK;
    @Basic(optional = false)
    @Column(name = "BUY_QUANTITY")
    private int buyQuantity;
    @Basic(optional = false)
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BuyOrder buyOrder;
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;

    public DetailedBuyOrder() {
    }

    public DetailedBuyOrder(DetailedBuyOrderPK detailedBuyOrderPK) {
        this.detailedBuyOrderPK = detailedBuyOrderPK;
    }

    public DetailedBuyOrder(DetailedBuyOrderPK detailedBuyOrderPK, int buyQuantity, int unitPrice) {
        this.detailedBuyOrderPK = detailedBuyOrderPK;
        this.buyQuantity = buyQuantity;
        this.unitPrice = unitPrice;
    }

    public DetailedBuyOrder(int orderId, int itemId) {
        this.detailedBuyOrderPK = new DetailedBuyOrderPK(orderId, itemId);
    }

    public DetailedBuyOrderPK getDetailedBuyOrderPK() {
        return detailedBuyOrderPK;
    }

    public void setDetailedBuyOrderPK(DetailedBuyOrderPK detailedBuyOrderPK) {
        this.detailedBuyOrderPK = detailedBuyOrderPK;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BuyOrder getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(BuyOrder buyOrder) {
        this.buyOrder = buyOrder;
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
        hash += (detailedBuyOrderPK != null ? detailedBuyOrderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailedBuyOrder)) {
            return false;
        }
        DetailedBuyOrder other = (DetailedBuyOrder) object;
        if ((this.detailedBuyOrderPK == null && other.detailedBuyOrderPK != null) || (this.detailedBuyOrderPK != null && !this.detailedBuyOrderPK.equals(other.detailedBuyOrderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StorePackage.DetailedBuyOrder[ detailedBuyOrderPK=" + detailedBuyOrderPK + " ]";
    }
    
}
