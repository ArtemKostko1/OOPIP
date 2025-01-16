import java.util.ArrayList;
import java.util.List;
import utils.MenuUtils;
import utils.CustomException;
import java.util.stream.Collectors;

public class GameRoom {
    private List<Toy> toys;
    private double budget;
    private int limitToysNumber;

    public GameRoom() {
        this.toys = new ArrayList<>();
        this.budget = 2500.0;
        this.limitToysNumber = 5;
    }

    public GameRoom(GameRoomData data) {
        this.toys = data.getToys() != null ? data.getToys() : new ArrayList<>();
        this.budget = data.getBudget();
        this.limitToysNumber = data.getLimitToysNumber();
    }

    public void addToy() {
        try {
            if (limitToysNumber == 0) {
                throw new CustomException("Достигнут лимит количества игрушек в комнате");
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Выберите тип игрушки: ");
            System.out.println("--------------------------------------------------");
            System.out.println("Бюджет: " + budget);
            System.out.println("Лимит игрушек: " + limitToysNumber);
            System.out.println("*************************");
            System.out.println("1. Машина");
            System.out.println("2. Кукла");
            System.out.println("3. Мяч");
            System.out.println("4. Кубик");
            System.out.println("0. Выход");
            System.out.println("*************************");

            int toyTypeChoice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3, 4});

            if (toyTypeChoice == 0) return; // Выход в главное меню

            System.out.println("--------------------------------------------------");

            String name = MenuUtils.getValidStringInput("Введите имя игрушки: ");

            double price = MenuUtils.getValidDoubleInput("Введите цену игрушки: ");

            if (price > budget) {
                throw new CustomException("Недостаточно бюджета для покупки этой игрушки. Остаток бюджета: " + budget);
            }

            int ageGroup = MenuUtils.getValidIntInput("Введите возрастную группу игрушки: ");

            Toy toy = createToy(toyTypeChoice, name, price, ageGroup);

            if (toy != null) {
                toys.add(toy);
                budget -= price;
                limitToysNumber--;
                System.out.println("--------------------------------------------------");
                System.out.println("!------------------------!");
                System.out.println("Игрушка добавлена!");
                System.out.println("!------------------------!");
                System.out.println("--------------------------------------------------");
            }
        } catch (CustomException e) {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println(e.getMessage());
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        }
    }

    private Toy createToy(int toyTypeChoice, String name, double price, int ageGroup) {
        switch (toyTypeChoice) {
            case 1:
                Car.CarSize size = selectCarSize();
                return new Car(name, price, ageGroup, size);
            case 2:
                return new Doll(name, price, ageGroup);
            case 3:
                return new Ball(name, price, ageGroup);
            case 4:
                return new Cube(name, price, ageGroup);
            default:
                return null;
        }
    }

    private Car.CarSize selectCarSize() {
        System.out.println("Выберите размер машины:");
        System.out.println("*************************");
        System.out.println("1. Большая");
        System.out.println("2. Средняя");
        System.out.println("3. Маленькая");
        System.out.println("*************************");

        int carSizeChoice = MenuUtils.getValidMenuChoice(new int[]{1, 2, 3});
        System.out.println("--------------------------------------------------");
        switch (carSizeChoice) {
            case 1:
                return Car.CarSize.LARGE;
            case 2:
                return Car.CarSize.MEDIUM;
            case 3:
                return Car.CarSize.SMALL;
            default:
                throw new IllegalArgumentException("Некорректный выбор размера машины");
        }
    }

    public void sortToys() {
        if (!toys.isEmpty()) {
            toys.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Сортировка игрушек выполнена");
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Сортировка невозможна, игрушки для комнаты отсутствуют");
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        }
    }

    public void findToysByAgeGroup() {
        int ageGroup = MenuUtils.getValidIntInput("Введите возрастную группу игрушки: ");
        System.out.println("--------------------------------------------------");

        // Используем временную коллекцию для хранения найденных игрушек
        List<Toy> foundToys = toys.stream()
                .filter(toy -> toy.getAgeGroup() == ageGroup)
                .collect(Collectors.toList());

        if (!foundToys.isEmpty()) {
            System.out.println("Найденные игрушки:");
            System.out.println("*************************");
            foundToys.forEach(System.out::println);
            System.out.println("*************************");
        } else {
            System.out.println("!------------------------!");
            System.out.println("Игрушки с указанной возрастной группой не найдены");
            System.out.println("!------------------------!");
        }
        System.out.println("--------------------------------------------------");
    }

    public void printAllToys() {
        if (!toys.isEmpty()) {
        System.out.println("--------------------------------------------------");
        System.out.println("Все игрушки:");
        System.out.println("*************************");
        toys.forEach(toy -> System.out.println(toy.toString()));
        System.out.println("*************************");
        System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Игрушки для комнаты отсутствуют");
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        }
    }

    public GameRoomData getGameRoomData() {
        return new GameRoomData(toys, budget, limitToysNumber);
    }
}