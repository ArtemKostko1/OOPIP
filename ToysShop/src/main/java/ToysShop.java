import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import utils.MenuUtils;
import java.util.stream.Collectors;

public class ToysShop {
    private final ToysShopData toysShopData;
    private String sizeFilter = null; // Фильтр по размеру
    private String categoryFilter = null; // Фильтр по категории
    private List<Toy> filteredToys; // Хранение отфильтрованных данных

    // Массив категорий для фильтрации
    private static final String[] categories = {
            "Машинки",
            "Куклы",
            "Мячи",
            "Мягкие игрушки",
            "Роботы"
    };

    public ToysShop(ToysShopData toysShopData) {
        this.toysShopData = toysShopData;
        this.filteredToys = new ArrayList<>(toysShopData.getToys());
    }

    public ToysShopData getToysShopData() {
        return toysShopData;
    }

    public void printAllToys() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayAllToys(filteredToys);
            System.out.println("*************************");
            System.out.println("Меню:");
            System.out.println("1. Фильтры");
            System.out.println("2. Сортировка");
            System.out.println("3. Добавить в корзину");
            System.out.println("0. Вернуться в главное меню");
            System.out.println("*************************");

            int choice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3});

            switch (choice) {
                case 1:
                    showFiltersMenu();
                    break;
                case 2:
                    showSortMenu();
                    break;
                case 3:
                    System.out.print("Введите номер игрушки для добавления в корзину: ");
                    int id = scanner.nextInt();
                    addToCart(id);
                    break;
                case 0:
                    return; // Выход в главное меню
                default:
                    break;
            }
        }
    }

    // Общий метод для отображения каталога
    private void displayAllToys(List<Toy> toysToDisplay) {
        System.out.println("--------------------------------------------------");
        System.out.println("Каталог игрушек:");
        System.out.println("*************************");
        if (toysToDisplay.isEmpty()) {
            System.out.println("Нет игрушек, соответствующих фильтрам.");
        } else {
            for (Toy toy : toysToDisplay) {
                System.out.printf("ID: %d, Название: %s, Цена: %.2f, Размер: %s, Категория: %s%n",
                        toy.getId(), toy.getName(), toy.getPrice(), toy.getSize(), toy.getCategory());
            }
        }
    }

    // Метод отображения подменю фильтров
    private void showFiltersMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayAllToys(filteredToys);
            System.out.println("*************************");
            System.out.println("Меню фильтров:");
            System.out.println("1. Добавить фильтрацию по размеру");
            System.out.println("2. Добавить фильтрацию по категории");
            System.out.println("3. Сбросить фильтры");
            System.out.println("0. Назад в меню каталога");
            System.out.println("*************************");

            int choice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3});

            switch (choice) {
                case 1:
                    filterBySize();
                    break;
                case 2:
                    filterByCategory();
                    break;
                case 3:
                    resetFilters();
                    break;
                case 0:
                    filteredToys = applyFilters(toysShopData.getToys());
                    return;
                default:
                    break;
            }
        }
    }

    // Метод отображения подменю сортировки
    private void showSortMenu() {
        while (true) {
            displayAllToys(filteredToys);
            System.out.println("*************************");
            System.out.println("Меню сортировки:");
            System.out.println("1. По возрастанию цены");
            System.out.println("2. По убыванию цены");
            System.out.println("3. Сброс сортировки");
            System.out.println("0. Отмена");
            System.out.println("*************************");

            int choice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3});

            switch (choice) {
                case 1:
                    sortAscending();
                    break;
                case 2:
                    sortDescending();
                    break;
                case 3:
                    filteredToys = applyFilters(toysShopData.getToys());
                    System.out.println("Сортировка сброшена.");
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    // Метод фильтрации по размеру
    private void filterBySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Выберите размер:");
        System.out.println("1. Маленькая");
        System.out.println("2. Средняя");
        System.out.println("3. Большая");
        System.out.println("0. Отмена");
        System.out.println("*************************");

        int sizeChoice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3});

        switch (sizeChoice) {
            case 1:
                sizeFilter = "Маленькая";
                break;
            case 2:
                sizeFilter = "Средняя";
                break;
            case 3:
                sizeFilter = "Большая";
                break;
            case 0:
                if (sizeFilter != null) {
                    sizeFilter = null; // Сброс фильтрации
                    System.out.println("Фильтрация по размеру сброшена.");
                }
                break;
            default:
                break;
        }

        filteredToys = applyFilters(toysShopData.getToys());
    }

    // Метод фильтрации по категории
    private void filterByCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Выберите категорию:");

        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%d. %s%n", i + 1, categories[i]);
        }

        System.out.println("0. Отмена");
        System.out.println("*************************");

        int[] validChoices = new int[categories.length + 1];
        validChoices[0] = 0;
        for (int i = 0; i < categories.length; i++) {
            validChoices[i + 1] = i + 1;
        }

        int categoryChoice = MenuUtils.getValidMenuChoice(validChoices);

        if (categoryChoice == 0) {
            categoryFilter = null; // Сброс фильтрации
            System.out.println("Фильтрация по категории сброшена.");
        } else {
            categoryFilter = categories[categoryChoice - 1];
        }

        // Применяем фильтры после изменения
        filteredToys = applyFilters(toysShopData.getToys());
    }

    // Метод сброса фильтров
    private void resetFilters() {
        sizeFilter = null;
        categoryFilter = null;
        System.out.println("Фильтры сброшены.");

        displayAllToys(filteredToys);
    }

    // Сортировка по возрастанию (Runnable)
    private void sortAscending() {
        Runnable sortTask = () -> {
            filteredToys = filteredToys.stream()
                    .sorted(Comparator.comparingDouble(Toy::getPrice))
                    .collect(Collectors.toList());
            System.out.println("Сортировка по возрастанию завершена.");
            displayAllToys(filteredToys);
        };
        Thread thread = new Thread(sortTask);
        thread.start();
        try {
            thread.join(); // Ждём завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Сортировка по убыванию (Thread)
    private void sortDescending() {
        Thread sortThread = new Thread(() -> {
            filteredToys = filteredToys.stream()
                    .sorted(Comparator.comparingDouble(Toy::getPrice).reversed())
                    .collect(Collectors.toList());
            System.out.println("Сортировка по убыванию завершена.");
            displayAllToys(filteredToys);
        });
        sortThread.start();
        try {
            sortThread.join(); // Ждём завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Применение фильтров к игрушкам
    private List<Toy> applyFilters(List<Toy> toys) {
        List<Toy> filtered = new ArrayList<>(toys);
        if (sizeFilter != null) {
            filtered = filtered.stream()
                    .filter(toy -> toy.getSize().equalsIgnoreCase(sizeFilter))
                    .collect(Collectors.toList());
        }
        if (categoryFilter != null) {
            filtered = filtered.stream()
                    .filter(toy -> toy.getCategory().equalsIgnoreCase(categoryFilter))
                    .collect(Collectors.toList());
        }
        return filtered;
    }

    // Метод добавления игрушки в корзину
    private void addToCart(int id) {
        List<Toy> filteredToys = new ArrayList<>(toysShopData.getToys());

        // Применяем фильтры (если они есть)
        if (sizeFilter != null) {
            filteredToys = filteredToys.stream()
                    .filter(toy -> toy.getSize().equalsIgnoreCase(sizeFilter))
                    .collect(Collectors.toList());
        }

        if (categoryFilter != null) {
            filteredToys = filteredToys.stream()
                    .filter(toy -> toy.getCategory().equalsIgnoreCase(categoryFilter))
                    .collect(Collectors.toList());
        }

        // Находим игрушку по ID среди отфильтрованных игрушек
        Toy toy = filteredToys.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (toy != null) {
            // Проверка, есть ли уже игрушка в корзине
            boolean isAlreadyInCart = toysShopData.getShoppingCart().stream()
                    .anyMatch(t -> t.getId() == id);

            if (isAlreadyInCart) {
                System.out.println("Данная игрушка уже добавлена в корзину.");
            } else {
                toysShopData.getShoppingCart().add(toy);
                System.out.printf("Игрушка \"%s\" успешно добавлена в корзину.%n", toy.getName());
            }
        } else {
            System.out.println("Игрушка указанным номером не найдена.");
        }

        displayAllToys(filteredToys);
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