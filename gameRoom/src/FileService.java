import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileService {
    private static final String FILE_NAME = "toys.dat";

    public static void saveToys(List<Toy> toys) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(toys);
                System.out.println("Сохранение игрушек выполнено успешно.");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении игрушек: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    public static List<Toy> loadToys() {
        List<Toy> toys = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            toys = (List<Toy>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Создание нового файла...");
            toys = createNewFileAndReturnEmptyList();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке игрушек: " + e.getMessage());
        }
        return toys;
    }

    private static List<Toy> createNewFileAndReturnEmptyList() {
        List<Toy> toys = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            file.createNewFile();
            System.out.println("Файл создан: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
        return toys;
    }
}
