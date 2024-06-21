import java.util.Scanner;
import utils.MenuUtils;

public class GameRoomMenu {
    private static Scanner scanner = new Scanner(System.in);
    private GameRoom gameRoom; // добавляем поле для GameRoom

    public GameRoomMenu() {
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

            int menuChoice = MenuUtils.getValidMenuChoice(new int[]{0, 1, 2, 3, 4});

            switch (menuChoice) {
                case 1:
                    gameRoom.addToy();
                    break;
                case 2:
                    gameRoom.sortToys();
                    break;
                case 3:
                    gameRoom.findToysByName();
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