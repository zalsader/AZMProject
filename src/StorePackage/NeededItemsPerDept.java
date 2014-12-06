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
@Table(name = "NEEDED_ITEMS_PER_DEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NeededItemsPerDept.findAll", query = "SELECT n FROM NeededItemsPerDept n"),
    @NamedQuery(name = "NeededItemsPerDept.findByDeptId", query = "SELECT n FROM NeededItemsPerDept n WHERE n.deptId.deptId = :deptId"),
    @NamedQuery(name = "NeededItemsPerDept.findByItemId", query = "SELECT n FROM NeededItemsPerDept n WHERE n.itemId.itemId = :itemId"),
    @NamedQuery(name = "NeededItemsPerDept.findByNeededQuantity", query = "SELECT n FROM NeededItemsPerDept n WHERE n.neededQuantity = :neededQuantity")})
public class NeededItemsPerDept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "NEEDED_QUANTITY")
    private BigInteger neededQuantity;
    @Id
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    @ManyToOne
    private Departments deptId;
    @Id
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    @ManyToOne
    private Items itemId;

    public NeededItemsPerDept() {
    }

    public BigInteger getNeededQuantity() {
        return neededQuantity;
    }

    public void setNeededQuantity(BigInteger neededQuantity) {
        this.neededQuantity = neededQuantity;
    }

    public Departments getDeptId() {
        return deptId;
    }

    public void setDeptId(Departments deptId) {
        this.deptId = deptId;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }
    
}
