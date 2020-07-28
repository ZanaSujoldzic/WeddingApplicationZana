
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Category;


@Local
public interface CategoryFacadeLocal {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    List<Category> findRange(int[] range);

    int count();
    
}
