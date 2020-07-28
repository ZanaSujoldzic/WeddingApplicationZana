
package wedding.screen;

import java.io.Serializable;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.PurchaseProduct;
import wedding.entity.facade.PurchaseProductFacadeLocal;

@Named
@SessionScoped
public class PurchaseProductManagedBean implements Serializable {

    @Inject
    private PurchaseProductFacadeLocal purchaseProductFacadeLocal;
    
    private String name;
    private String surname;
    private LocalDate date;
    private PurchaseProduct purchaseProduct = new PurchaseProduct();

    public PurchaseProductManagedBean() {
    }
    

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void create(){
        purchaseProductFacadeLocal.create(purchaseProduct);
    }

}
