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
@Table(name = "TO_BE_PURCHASED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToBePurchased.findAll", query = "SELECT t FROM ToBePurchased t"),
    @NamedQuery(name = "ToBePurchased.findByItemId", query = "SELECT t FROM ToBePurchased t WHERE t.itemId = :itemId"),
    @NamedQuery(name = "ToBePurchased.findByAvailableQuantity", query = "SELECT t FROM ToBePurchased t WHERE t.availableQuantity = :availableQuantity"),
    @NamedQuery(name = "ToBePurchased.findByQuantityNeeded", query = "SELECT t FROM ToBePurchased t WHERE t.quantityNeeded = :quantityNeeded")})
public class ToBePurchased implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "AVAILABLE_QUANTITY")
    private String availableQuantity;
    @Column(name = "QUANTITY_NEEDED")
    private BigInteger quantityNeeded;

    public ToBePurchased() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public BigInteger getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(BigInteger quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }
    
}
