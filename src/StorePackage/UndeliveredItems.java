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
@Table(name = "UNDELIVERED_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UndeliveredItems.findAll", query = "SELECT u FROM UndeliveredItems u"),
    @NamedQuery(name = "UndeliveredItems.findByItemId", query = "SELECT u FROM UndeliveredItems u WHERE u.itemId = :itemId"),
    @NamedQuery(name = "UndeliveredItems.findByNeededQuantity", query = "SELECT u FROM UndeliveredItems u WHERE u.neededQuantity = :neededQuantity")})
public class UndeliveredItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "NEEDED_QUANTITY")
    private BigInteger neededQuantity;

    public UndeliveredItems() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigInteger getNeededQuantity() {
        return neededQuantity;
    }

    public void setNeededQuantity(BigInteger neededQuantity) {
        this.neededQuantity = neededQuantity;
    }
    
}
