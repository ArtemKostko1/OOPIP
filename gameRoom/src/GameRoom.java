import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.MenuUtils;
import utils.CustomException;

public class GameRoom {
    private static Scanner scanner = new Scanner(System.in);
    private List<Toy> toys;
    private double budget;
    private int limitToysNumber;

    public GameRoom() {
        this.toys = new ArrayList<>();
        this.budget = 0.0;
        this.limitToysNumber = 7;
    }

    public GameRoom(List<Toy> toys) {
        this.toys = toys != null ? toys : new ArrayList<>();
        this.budget = 0.0;
        this.limitToysNumber = 7;
    }

    public void addToy() {
        while (true) {
            try {
                if (limitToysNumber == 0) {
                    throw new CustomException("Достигнут лимит количества игрушек в комнате");
                }

                System.out.println("Выберите тип игрушки: ");
                System.out.println("--------------------------------------------------");
                System.out.println("Бюджет: " + budget);
                System.out.println("Лимит игрушек: " + limitToysNumber);
                System.out.println("--------------------------------------------------");
                System.out.println("1. Машина");
                System.out.println("2. Кукла");
                System.out.println("3. Мяч");
                System.out.println("4. Кубик");
                System.out.println("0. Выход");
                System.out.println("--------------------------------------------------");

                int toyTypeChoice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3, 4});

                if (toyTypeChoice == 0) {
                    return; // Выход в главное меню
                }

                String name = MenuUtils.getValidStringInput("Введите имя игрушки:");

                double price = MenuUtils.getValidDoubleInput("Введите цену игрушки:");

                if (price > budget) {
                    throw new CustomException("Недостаточно бюджета для покупки этой игрушки. Остаток бюджета: " + budget);
                }

                int ageGroup = MenuUtils.getValidIntInput("Введите возрастную группу игрушки:");

                Toy toy = null;

                switch (toyTypeChoice) {
                    case 1:
                        Car.CarSize size;
                        while (true) {
                            System.out.println("Выберите размер машины:");
                            System.out.println("--------------------------------------------------");
                            System.out.println("1. Большая");
                            System.out.println("2. Средняя");
                            System.out.println("3. Маленькая");
                            System.out.println("--------------------------------------------------");

                            int carSizeChoice = MenuUtils.getValidMenuChoice(new int[]{1, 2, 3});

                            switch (carSizeChoice) {
                                case 1:
                                    size = Car.CarSize.LARGE;
                                    break;
                                case 2:
                                    size = Car.CarSize.MEDIUM;
                                    break;
                                case 3:
                                    size = Car.CarSize.SMALL;
                                    break;
                                default:
                                    System.out.println("Некорректный ввод. Пожалуйста, выберите снова:");
                                    continue;
                            }
                            break;
                        }
                        toy = new Car(name, price, ageGroup, size);
                        break;
                    case 2:
                        toy = new Doll(name, price, ageGroup);
                        break;
                    case 3:
                        toy = new Ball(name, price, ageGroup);
                        break;
                    case 4:
                        toy = new Cube(name, price, ageGroup);
                        break;
                    case 0:
                        break;
                }

                toys.add(toy);
                budget -= price;
                limitToysNumber--;
                System.out.println("Игрушка добавлена!");
            } catch (CustomException e) {
                System.out.println("!................................................!");
                System.out.println(e.getMessage());
                System.out.println("!................................................!");
                return; // Выход в главное меню
            }
        }
    }

    public void setBudget() {
        this.budget = MenuUtils.getValidDoubleInput("Введите бюджет на закупку игрушек:");
    }

    public double getBudget() {
        return this.budget;
    }

    public List<Toy> getToys() {
        return this.toys;
    }

    public void sortToys() {
        toys.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
        System.out.println("Сортировка игрушек...");
    }

    public void findToysByAgeGroup() {
        int ageGroup = MenuUtils.getValidIntInput("Введите возрастную группу игрушки:");

        System.out.println("..................................................");
        System.out.println("Найденные игрушки");

        boolean found = false;
        for (Toy toy : toys) {
            if (toy.getAgeGroup() == ageGroup) {
                System.out.println(toy.toString());
                found = true;
            }
        }

        System.out.println("..................................................");

        if (!found) {
            System.out.println("Игрушки с указанной возрастной группой не найдены.");
            System.out.println("..................................................");
        }
    }

    public void printAllToys() {
        System.out.println("--------------------------------------------------");
        System.out.println("Все игрушки:");
        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
        System.out.println("--------------------------------------------------");
    }
}