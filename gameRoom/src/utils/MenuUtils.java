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

    public static String getValidStringInput(String prompt) {
        String name;
        while (true) {
            System.out.print(prompt);
            name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Некорректный ввод. Имя не должно быть пустым. Пожалуйста, введите имя еще раз");
            }
        }
        return name;
    }

    public static double getValidDoubleInput(String prompt) {
        double value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Пожалуйста, введите положительное числовое значение");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите числовое значение");
            }
        }
        return value;
    }

    public static int getValidIntInput(String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    System.out.println("--------------------------------------------------");
                    break;
                } else {
                    System.out.println("Пожалуйста, введите положительное целочисленное значение");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите целочисленное значение");
            }
        }
        return value;
    }
}