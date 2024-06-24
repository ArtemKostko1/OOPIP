import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов в массиве (k): ");
        int k = scanner.nextInt();

        double[] array = new double[k];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < k; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.println("Исходный массив:");
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double average = sum / k;

        System.out.println("Среднее значение: " + average);

        // Count elements that are less than the average
        int count = 0;
        for (double num : array) {
            if (num < average) {
                count++;
            }
        }

        // Create a new array to store the result
        double[] resultArray = new double[count];
        int index = 0;
        for (double num : array) {
            if (num < average) {
                resultArray[index++] = num;
            }
        }

        System.out.println("Результирующий массив (удалены элементы, значения которых меньше среднего значения):");
        for (double num : resultArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
