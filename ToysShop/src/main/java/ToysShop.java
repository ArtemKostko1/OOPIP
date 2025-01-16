import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.MenuUtils;

public class ToysShop {
    private final ToysShopData toysShopData;

    public ToysShop(ToysShopData toysShopData) {
        this.toysShopData = toysShopData;
    }

    public ToysShopData getToysShopData() {
        return toysShopData;
    }

    public void printAllToys() {
        System.out.println("--------------------------------------------------");
        System.out.println("Каталог игрушек:");
        System.out.println("*************************");
        for (Toy toy : toysShopData.getToys()) {
            System.out.printf("ID: %d, Название: %s, Цена: %.2f, Размер: %s, Категория: %s%n",
                    toy.getId(), toy.getName(), toy.getPrice(), toy.getSize(), toy.getCategory());
        }
        System.out.println("*************************");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить в корзину");
            System.out.println("0. Выход");
            System.out.println("*************************");

            int choice = MenuUtils.getValidMenuChoice(new int[]{0, 1});

            switch (choice) {
                case 1:
                    System.out.print("Введите номер игрушки для добавления в корзину: ");
                    int id = scanner.nextInt();
                    addToCart(id);
                    break;
                case 0:
                    return; // Выход в главное меню
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод добавления игрушки в корзину
    private void addToCart(int id) {
        Toy toy = findToyById(id);
        if (toy != null) {
            toysShopData.getShoppingCart().add(toy);
            System.out.printf("Игрушка \"%s\" успешно добавлена в корзину.%n", toy.getName());
        } else {
            System.out.println("Игрушка с таким ID не найдена.");
        }
    }

    // Метод поиска игрушки по ID
    private Toy findToyById(int id) {
        for (Toy toy : toysShopData.getToys()) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    // Метод вывода списка игрушек в корзине
    public void printShoppingCart() {
        List<Toy> shoppingCart = toysShopData.getShoppingCart();
        if (shoppingCart.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Список игрушек в корзине:");
            System.out.println("--------------------------------------------------");
            for (Toy toy : shoppingCart) {
                System.out.printf("ID: %d, Название: %s, Цена: %.2f, Размер: %s, Категория: %s%n",
                        toy.getId(), toy.getName(), toy.getPrice(), toy.getSize(), toy.getCategory());
            }
            System.out.println("--------------------------------------------------");

            // Вычисление общей суммы корзины
            double totalPrice = shoppingCart.stream()
                    .mapToDouble(Toy::getPrice)
                    .sum();
            System.out.printf("Общая сумма корзины: %.2f%n", totalPrice);
        }
    }
}