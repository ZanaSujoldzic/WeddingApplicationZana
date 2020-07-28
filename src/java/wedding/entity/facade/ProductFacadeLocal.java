package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Product;

@Local
public interface ProductFacadeLocal {

    public List<Product> getAllProducts();

    public List<Product> getAllDresses();

    public List<Product> getAllSuits();

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();

}
