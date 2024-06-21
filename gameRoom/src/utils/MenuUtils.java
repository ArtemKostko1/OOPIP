package utils;
import java.util.Scanner;

// MenuUtils.java
public class MenuUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getValidMenuChoice(int[] validChoices) {
        int choice = -1;
        while (true) {
            System.out.print("Введите пункт меню: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Некорректный ввод. Пожалуйста, введите одно из чисел: " + formatValidChoices(validChoices));
                continue;
            }
            try {
                choice = Integer.parseInt(input);
                boolean isValid = false;
                for (int validChoice : validChoices) {
                    if (choice == validChoice) {
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    break;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите одно из чисел: " + formatValidChoices(validChoices));
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите одно из чисел: " + formatValidChoices(validChoices));
            }
        }
        return choice;
    }

    public static String formatValidChoices(int[] validChoices) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < validChoices.length; i++) {
            formatted.append(validChoices[i]);
            if (i < validChoices.length - 1) {
                formatted.append(", ");
            }
        }
        return formatted.toString();
    }
}