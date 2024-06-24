import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileService {
    private static final String FILE_NAME = "toys.dat";
    private static final double DEFAULT_BUDGET = 2500.0;
    private static final int DEFAULT_LIMIT_TOYS_NUMBER = 7;

    public static void saveGameRoomData(GameRoomData gameRoomData) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(gameRoomData);
                System.out.println("Сохранение данных игровой комнаты выполнено успешно.");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении данных игровой комнаты: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    public static GameRoomData loadGameRoomData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (GameRoomData) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Файл не найден. Создание нового файла...");
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
            return createNewFileAndReturnDefaultData();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Ошибка при загрузке данных игровой комнаты: " + e.getMessage());
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
            return null;
        }
    }

    private static GameRoomData createNewFileAndReturnDefaultData() {
        List<Toy> toys = new ArrayList<>();
        double budget = DEFAULT_BUDGET;
        int limitToysNumber = DEFAULT_LIMIT_TOYS_NUMBER;

        try {
            File file = new File(FILE_NAME);
            file.createNewFile();
            System.out.println("!------------------------!");
            System.out.println("Файл создан: " + FILE_NAME);
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        } catch (IOException e) {
            System.out.println("--------------------------------------------------");
            System.out.println("!------------------------!");
            System.out.println("Ошибка при создании файла: " + e.getMessage());
            System.out.println("!------------------------!");
            System.out.println("--------------------------------------------------");
        }

        return new GameRoomData(toys, budget, limitToysNumber);
    }
}
