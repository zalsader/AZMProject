/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalstorage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MahmoodKhalid
 */
@Entity
@Table(name = "ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Items.findByItemName", query = "SELECT i FROM Items i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Items.findByItemUnit", query = "SELECT i FROM Items i WHERE i.itemUnit = :itemUnit")})
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "ITEM_UNIT")
    private String itemUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Collection<DetailedDelivery> detailedDeliveryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Collection<DetailedReceivingForm> detailedReceivingFormCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Collection<DetailedBuyOrder> detailedBuyOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Collection<DetailedRequestOfItems> detailedRequestOfItemsCollection;

    public Items() {
    }

    public Items(Integer itemId) {
        this.itemId = itemId;
    }

    public Items(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    @XmlTransient
    public Collection<DetailedDelivery> getDetailedDeliveryCollection() {
        return detailedDeliveryCollection;
    }

    public void setDetailedDeliveryCollection(Collection<DetailedDelivery> detailedDeliveryCollection) {
        this.detailedDeliveryCollection = detailedDeliveryCollection;
    }

    @XmlTransient
    public Collection<DetailedReceivingForm> getDetailedReceivingFormCollection() {
        return detailedReceivingFormCollection;
    }

    public void setDetailedReceivingFormCollection(Collection<DetailedReceivingForm> detailedReceivingFormCollection) {
        this.detailedReceivingFormCollection = detailedReceivingFormCollection;
    }

    @XmlTransient
    public Collection<DetailedBuyOrder> getDetailedBuyOrderCollection() {
        return detailedBuyOrderCollection;
    }

    public void setDetailedBuyOrderCollection(Collection<DetailedBuyOrder> detailedBuyOrderCollection) {
        this.detailedBuyOrderCollection = detailedBuyOrderCollection;
    }

    @XmlTransient
    public Collection<DetailedRequestOfItems> getDetailedRequestOfItemsCollection() {
        return detailedRequestOfItemsCollection;
    }

    public void setDetailedRequestOfItemsCollection(Collection<DetailedRequestOfItems> detailedRequestOfItemsCollection) {
        this.detailedRequestOfItemsCollection = detailedRequestOfItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospitalstorage.Items[ itemId=" + itemId + " ]";
    }
    
}
