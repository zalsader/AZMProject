/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "BUY_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuyOrder.findAll", query = "SELECT b FROM BuyOrder b"),
    @NamedQuery(name = "BuyOrder.findByOrderId", query = "SELECT b FROM BuyOrder b WHERE b.orderId = :orderId"),
    @NamedQuery(name = "BuyOrder.findByOrderDate", query = "SELECT b FROM BuyOrder b WHERE b.orderDate = :orderDate")})
public class BuyOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="buy_order_pk_seq")
    @SequenceGenerator(name="buy_order_pk_seq", sequenceName="buy_order_pk_seq", allocationSize=1)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyOrder")
    private Collection<DetailedBuyOrder> detailedBuyOrderCollection;
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID")
    @ManyToOne(optional = false)
    private Suppliers supplierId;

    public BuyOrder() {
    }

    public BuyOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public BuyOrder(Integer orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @XmlTransient
    public Collection<DetailedBuyOrder> getDetailedBuyOrderCollection() {
        return detailedBuyOrderCollection;
    }

    public void setDetailedBuyOrderCollection(Collection<DetailedBuyOrder> detailedBuyOrderCollection) {
        this.detailedBuyOrderCollection = detailedBuyOrderCollection;
    }

    public Suppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Suppliers supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyOrder)) {
            return false;
        }
        BuyOrder other = (BuyOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + orderId + ": "+orderDate;
    }
    
}
