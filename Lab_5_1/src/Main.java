import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность массивов: ");
        int size = scanner.nextInt();

        if (size < 1) {
            System.out.println("Ошибка. Размерность массива должна быть больше нуля!");
            return;
        }

        int[] A = new int[size];
        int[] B = new int[size];

        System.out.println("Введите элементы массива A:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент A[" + i + "]: ");
            A[i] = scanner.nextInt();
        }

        System.out.println("Введите элементы массива B:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент B[" + i + "]: ");
            B[i] = scanner.nextInt();
        }

        for (int i = 0; i < size; i++) {
            if (A[i] != 0) {
                double x = -B[i] / (double) A[i];
                System.out.println("Результат: x = " + x);
            } else {
                System.out.println("Результат: x = 0");
            }
        }
    }
}
