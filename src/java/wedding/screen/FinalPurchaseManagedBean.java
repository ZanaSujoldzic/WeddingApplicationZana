
package wedding.screen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.Card;
import wedding.entity.Purchase;
import wedding.entity.facade.CardFacadeLocal;
import wedding.shoppingCart.ShoppingCartItem;


@Named
@SessionScoped

public class FinalPurchaseManagedBean implements Serializable {
    
 @Inject
 private CardFacadeLocal cardFacadeLocal;
 
 private Card card = new Card();
 private Purchase purchase = new Purchase();


    public Purchase getPurchase() {
        return purchase;
    }
    
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    public boolean validate(){
        return cardFacadeLocal.validate(card);
    }
 
 
    
    
}
