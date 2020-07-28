
package wedding.entity.facade;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Local
public interface RegisterFacadeLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(String name, String surname, String username, String password);
}
