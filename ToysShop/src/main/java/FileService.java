import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String TOYS_FILE_NAME = "toys.txt";
    private static final String SHOPPING_CART_FILE_NAME = "shoppingCart.txt";
    private static final Gson gson = new Gson();

    public static void saveShoppingCart(ToysShopData toysShopData) {
        try (Writer writer = new FileWriter(SHOPPING_CART_FILE_NAME)) {
            List<Toy> shoppingCart = toysShopData.getShoppingCart();
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // Создаем GSON с поддержкой форматирования JSON
            writer.write(prettyGson.toJson(shoppingCart)); // Записываем весь список в файл в виде форматированного JSON
            System.out.println("Сохранение корзины выполнено успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении корзины: " + e.getMessage());
        }
    }


    public static ToysShopData loadToysShopData() {
        File file = new File(TOYS_FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл каталога игрушек не найден. Создание нового файла...");
            createEmptyFile(TOYS_FILE_NAME);
            return new ToysShopData(new ArrayList<>());
        }

        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Toy>>() {}.getType();
            List<Toy> toys = gson.fromJson(reader, listType);
            System.out.println("Каталог игрушек успешно загружен.");
            return new ToysShopData(toys);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке каталога игрушек: " + e.getMessage());
        }

        return new ToysShopData(new ArrayList<>());
    }

    public static void loadShoppingCart(ToysShopData toysShopData) {
        File file = new File(SHOPPING_CART_FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл корзины не найден. Создание нового файла...");
            createEmptyFile(SHOPPING_CART_FILE_NAME);
            return;
        }

        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Toy>>() {}.getType();
            List<Toy> shoppingCart = gson.fromJson(reader, listType);
            toysShopData.setShoppingCart(shoppingCart);
            System.out.println("Корзина успешно загружена.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке корзины: " + e.getMessage());
        }
    }

    private static void createEmptyFile(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.write("[]"); // Создаем пустой JSON массив
            System.out.printf("Файл %s успешно создан.%n", fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла " + fileName + ": " + e.getMessage());
        }
    }
}
