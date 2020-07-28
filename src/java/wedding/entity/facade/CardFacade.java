package wedding.entity.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wedding.entity.Card;


@Stateless
public class CardFacade extends AbstractFacade<Card> implements CardFacadeLocal {

    @PersistenceContext(unitName = "TestWebPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public CardFacade() {
        super(Card.class);
    }
    
    

    @Override
    public boolean validate(Card card) {
        
        Query query = entityManager.createNamedQuery("Card.findByCvv");
        List<Card> cards = query.getResultList();
        for(Card validatedCard : cards ){
            if(validatedCard.equals(card)){
                return true;
            }
        }
        return false;
        
    }
}
