import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ToysShopData data = FileService.loadToysShopData();

        ToysShop toysShop;
        if (data == null) {
            toysShop = new ToysShop(new ToysShopData(new ArrayList<>()));
        } else {
            toysShop = new ToysShop(data);
        }

        FileService.loadShoppingCart(toysShop.getToysShopData());

        ToysShopMenu menu = new ToysShopMenu(toysShop);
        menu.showMenu();

        FileService.saveShoppingCart(toysShop.getToysShopData());
    }
}