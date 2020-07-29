package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.Card;

@Local
public interface CardFacadeLocal {
    
    
    public boolean validate(Card card);
    
    void create(Card card);

    void edit(Card card);

    void remove(Card card);

    Card find(Object id);

    List<Card> findAll();

    List<Card> findRange(int[] range);

    int count();
    
}
