/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Items.findByItemName", query = "SELECT i FROM Items i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Items.findByItemUnit", query = "SELECT i FROM Items i WHERE i.itemUnit = :itemUnit"),
    @NamedQuery(name = "Items.findByAvailableQuantity", query = "SELECT i FROM Items i WHERE i.availableQuantity = :availableQuantity"),
    @NamedQuery(name = "Items.findByMinimumQuantity", query = "SELECT i FROM Items i WHERE i.minimumQuantity = :minimumQuantity")})
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="items_pk_seq")
    @SequenceGenerator(name="items_pk_seq", sequenceName="items_pk_seq", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "ITEM_UNIT")
    private String itemUnit;
    @Column(name = "AVAILABLE_QUANTITY")
    private String availableQuantity;
    @Column(name = "MINIMUM_QUANTITY")
    private Integer minimumQuantity;

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

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
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
        return itemName+" ("+itemUnit+")";
    }
    
}
