
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Service;


@Local
public interface ServiceFacadeLocal {

    void create(Service service);

    void edit(Service service);

    void remove(Service service);

    Service find(Object id);

    List<Service> findAll();

    List<Service> findRange(int[] range);

    int count();
    
}
