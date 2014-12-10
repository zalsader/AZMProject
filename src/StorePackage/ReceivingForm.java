/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StorePackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zuhair
 */
@Entity
@Table(name = "RECEIVING_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceivingForm.findAll", query = "SELECT r FROM ReceivingForm r"),
    @NamedQuery(name = "ReceivingForm.findByReceivingId", query = "SELECT r FROM ReceivingForm r WHERE r.receivingId = :receivingId"),
    @NamedQuery(name = "ReceivingForm.findBySupplier", query = "SELECT r FROM ReceivingForm r WHERE r.supplierId.supplierId = :supplierId"),
    @NamedQuery(name = "ReceivingForm.findByReceivingDate", query = "SELECT r FROM ReceivingForm r WHERE r.receivingDate = :receivingDate")})
public class ReceivingForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receiving_form_pk_seq")
    @SequenceGenerator(name="receiving_form_pk_seq", sequenceName="receiving_form_pk_seq", allocationSize=1)
    @Column(name = "RECEIVING_ID")
    private Integer receivingId;
    @Basic(optional = false)
    @Column(name = "RECEIVING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivingDate;
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID")
    @ManyToOne(optional = false)
    private Suppliers supplierId;

    public ReceivingForm() {
    }

    public ReceivingForm(Integer receivingId) {
        this.receivingId = receivingId;
    }

    public ReceivingForm(Integer receivingId, Date receivingDate) {
        this.receivingId = receivingId;
        this.receivingDate = receivingDate;
    }

    public Integer getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(Integer receivingId) {
        this.receivingId = receivingId;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
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
        hash += (receivingId != null ? receivingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceivingForm)) {
            return false;
        }
        ReceivingForm other = (ReceivingForm) object;
        if ((this.receivingId == null && other.receivingId != null) || (this.receivingId != null && !this.receivingId.equals(other.receivingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + receivingId + ": "+receivingDate;
    }
    
}
