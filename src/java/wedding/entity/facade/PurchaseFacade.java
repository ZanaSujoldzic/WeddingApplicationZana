
package wedding.entity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wedding.entity.Purchase;


@Stateless
public class PurchaseFacade extends AbstractFacade<Purchase> implements PurchaseFacadeLocal {

    @PersistenceContext(unitName = "TestWebPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PurchaseFacade() {
        super(Purchase.class);
    }
    
}
