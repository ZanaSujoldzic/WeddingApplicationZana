package wedding.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "shops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shops.findAll", query = "SELECT s FROM Shops s")
    , @NamedQuery(name = "Shops.findById", query = "SELECT s FROM Shops s WHERE s.id = :id")
    , @NamedQuery(name = "Shops.findByName", query = "SELECT s FROM Shops s WHERE s.name = :name")
    , @NamedQuery(name = "Shops.findCatering", query = "SELECT s FROM Shops s WHERE s.idService.id = 1")
    , @NamedQuery(name = "Shops.findPhotoVideo", query = "SELECT s FROM Shops s WHERE s.idService.id = 2")
    , @NamedQuery(name = "Shops.findDecorations", query = "SELECT s FROM Shops s WHERE s.idService.id = 3")
    , @NamedQuery(name = "Shops.findByAddress", query = "SELECT s FROM Shops s WHERE s.address = :address")
    , @NamedQuery(name = "Shops.findByContact", query = "SELECT s FROM Shops s WHERE s.contact = :contact")
    , @NamedQuery(name = "Shops.findByPhoto", query = "SELECT s FROM Shops s WHERE s.photo = :photo")})
public class Shops implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "photo")
    private String photo;
    @JoinColumn(name = "id_service", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Service idService;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Shops() {
    }

    public Shops(Integer id) {
        this.id = id;
    }

    public Shops(Integer id, String name, String address, String contact, String description, String photo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.description = description;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Shops)) {
            return false;
        }
        Shops other = (Shops) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
