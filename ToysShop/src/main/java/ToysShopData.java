import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToysShopData implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Toy> toys;
    private List<Toy> shoppingCart;

    public ToysShopData(List<Toy> toys) {
        this.toys = toys;
        this.shoppingCart = new ArrayList<>();
    }

    public List<Toy> getToys() {
        return toys;
    }

    public List<Toy> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Toy> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
