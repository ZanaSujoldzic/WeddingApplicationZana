/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wedding.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zana
 */
@Entity
@Table(name = "purchase_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseProduct.findAll", query = "SELECT p FROM PurchaseProduct p")
    , @NamedQuery(name = "PurchaseProduct.findById", query = "SELECT p FROM PurchaseProduct p WHERE p.id = :id")
    , @NamedQuery(name = "PurchaseProduct.findByQuantity", query = "SELECT p FROM PurchaseProduct p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PurchaseProduct.findByDate", query = "SELECT p FROM PurchaseProduct p WHERE p.date = :date")})
public class PurchaseProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product idProduct;
    @JoinColumn(name = "id_purchase", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Purchase idPurchase;

    public PurchaseProduct() {
    }

    public PurchaseProduct(Integer id) {
        this.id = id;
    }

    public PurchaseProduct(Integer id, int quantity, Date date) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Purchase getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Purchase idPurchase) {
        this.idPurchase = idPurchase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseProduct)) {
            return false;
        }
        PurchaseProduct other = (PurchaseProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wedding.entity.PurchaseProduct[ id=" + id + " ]";
    }
    
}
