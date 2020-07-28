package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Shops;

@Local
public interface ShopsFacadeLocal {

    public List<Shops> findCatering();

    public List<Shops> findPhotoVideo();

    public List<Shops> findDecorations();

    void create(Shops shops);

    void edit(Shops shops);

    void remove(Shops shops);

    Shops find(Object id);

    public List<Shops> findAll();

    List<Shops> findRange(int[] range);

    int count();

}
