/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "DEMANDED_ITEMS_PER_SUPPLIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DemandedItemsPerSupplier.findAll", query = "SELECT d FROM DemandedItemsPerSupplier d"),
    @NamedQuery(name = "DemandedItemsPerSupplier.findByDemandedQuantity", query = "SELECT d FROM DemandedItemsPerSupplier d WHERE d.demandedQuantity = :demandedQuantity")})
public class DemandedItemsPerSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "DEMANDED_QUANTITY")
    private BigInteger demandedQuantity;
    @Id
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID")
    @ManyToOne
    private Suppliers supplierId;
    @Id
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    @ManyToOne
    private Items itemId;

    public DemandedItemsPerSupplier() {
    }

    public BigInteger getDemandedQuantity() {
        return demandedQuantity;
    }

    public void setDemandedQuantity(BigInteger demandedQuantity) {
        this.demandedQuantity = demandedQuantity;
    }

    public Suppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Suppliers supplierId) {
        this.supplierId = supplierId;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }
    
}
