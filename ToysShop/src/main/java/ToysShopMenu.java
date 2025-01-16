import utils.MenuUtils;

public class ToysShopMenu {
    private final ToysShop toysShop;

    public ToysShopMenu(ToysShop toysShop) {
        this.toysShop = toysShop;
    }

    public void showMenu() {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Меню магазина:");
            System.out.println("*************************");
            System.out.println("1. Каталог игрушек");
            System.out.println("2. Корзина");
            System.out.println("0. Выход");
            System.out.println("*************************");

            int menuChoice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2,});

            System.out.println("--------------------------------------------------");

            switch (menuChoice) {
                case 1:
                    toysShop.printAllToys();
                    break;
                case 2:
                    toysShop.printShoppingCart();
                    break;
                case 0:
                    System.out.println("Конец работы программы");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}