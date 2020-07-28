
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Product;
import wedding.entity.PurchaseProduct;


@Local
public interface PurchaseProductFacadeLocal {
    
    void create(PurchaseProduct purchaseProduct);

    void edit(PurchaseProduct purchaseProduct);

    void remove(PurchaseProduct purchaseProduct);

    PurchaseProduct find(Object id);

    List<PurchaseProduct> findAll();

    List<PurchaseProduct> findRange(int[] range);

    int count();
    
}
