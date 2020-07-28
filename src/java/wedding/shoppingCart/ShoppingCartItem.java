
package wedding.shoppingCart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import wedding.entity.Product;


public class ShoppingCartItem implements Serializable {
    
    private Product product;
    private List<ShoppingCartItem> shoppingCartItems;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Product product) {
        this.product = product;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    public BigDecimal getTotalPrice(){
       for(ShoppingCartItem sp : shoppingCartItems){
           BigDecimal totalPrice = sp.getProduct().getPrice();
           return totalPrice;
       } 
        return null;
    }
}
