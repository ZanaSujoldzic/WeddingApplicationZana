
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Purchase;


@Local
public interface PurchaseFacadeLocal {

    void create(Purchase purchase);

    void edit(Purchase purchase);

    void remove(Purchase purchase);

    Purchase find(Object id);

    List<Purchase> findAll();

    List<Purchase> findRange(int[] range);

    int count();
    
}
