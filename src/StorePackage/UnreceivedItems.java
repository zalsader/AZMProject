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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "UNRECEIVED_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnreceivedItems.findAll", query = "SELECT u FROM UnreceivedItems u"),
    @NamedQuery(name = "UnreceivedItems.findByItemId", query = "SELECT u FROM UnreceivedItems u WHERE u.itemId = :itemId"),
    @NamedQuery(name = "UnreceivedItems.findByDemandedQuantity", query = "SELECT u FROM UnreceivedItems u WHERE u.demandedQuantity = :demandedQuantity")})
public class UnreceivedItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "DEMANDED_QUANTITY")
    private BigInteger demandedQuantity;

    public UnreceivedItems() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigInteger getDemandedQuantity() {
        return demandedQuantity;
    }

    public void setDemandedQuantity(BigInteger demandedQuantity) {
        this.demandedQuantity = demandedQuantity;
    }
    
}
