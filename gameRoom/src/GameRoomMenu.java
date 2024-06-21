import java.util.Scanner;

public class GameRoomMenu {
    private Scanner scanner;
    private GameRoom gameRoom; // добавляем поле для GameRoom

    public GameRoomMenu() {
        this.scanner = new Scanner(System.in);
        this.gameRoom = new GameRoom();
    }

    public void showMenu() {
        while (true) {
            System.out.println("Главное меню:");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Добавить игрушку");
            System.out.println("2. Сортировать игрушки");
            System.out.println("3. Найти игрушки в диапазоне параметров");
            System.out.println("4. Вывести все игрушки");
            System.out.println("0. Выход");
            System.out.println("--------------------------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    gameRoom.addToy(scanner);
                    break;
                case 2:
                    gameRoom.sortToys();
                    break;
                case 3:
                    gameRoom.findToysByName(scanner);
                    break;
                case 4:
                    gameRoom.printAllToys();
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