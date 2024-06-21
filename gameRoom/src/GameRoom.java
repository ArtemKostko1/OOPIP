import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRoom {
    private List<Toy> toys;

    public GameRoom() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Scanner scanner) {
        System.out.println("Выберите тип игрушки: ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Машина");
        System.out.println("2. Кукла");
        System.out.println("3. Мяч");
        System.out.println("4. Кубик");
        System.out.println("--------------------------------------------------");

        int toyType = scanner.nextInt();

        System.out.println("Введите имя игрушки:");
        String name = scanner.next();

        System.out.println("Введите цену игрушки:");
        double price = scanner.nextDouble();

        System.out.println("Введите возрастную группу игрушки:");
        int ageGroup = scanner.nextInt();

        Toy toy = null;

        switch (toyType) {
            case 1:
                Car.CarSize size;
                while (true) {
                    System.out.println("Выберите размер машины:");
                    System.out.println("--------------------------------------------------");
                    System.out.println("1. Большая");
                    System.out.println("2. Средняя");
                    System.out.println("3. Маленькая");
                    System.out.println("--------------------------------------------------");
                    int sizeChoice = scanner.nextInt();

                    switch (sizeChoice) {
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
                toy = new Boll(name, price, ageGroup);
                break;
            case 4:
                toy = new Cube(name, price, ageGroup);
                break;
        }

        toys.add(toy);
        System.out.println("Игрушка добавлена!");
    }

    public void sortToys() {
        toys.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
        System.out.println("Сортировка игрушек...");
    }

    public void findToysByName(Scanner scanner) {
        System.out.println("Введите имя игрушки:");
        String name = scanner.next();

        for (Toy toy : toys) {
            if (toy.getName().equals(name)) {
                System.out.println("Игрушка найдена: " + toy.toString());
                return;
            }
        }

        System.out.println("Игрушка не найдена");
    }

    public void printAllToys() {
        System.out.println("Все игрушки:");
        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
    }
}