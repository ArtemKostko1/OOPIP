import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();

        if (rows < 1) {
            System.out.println("Ошибка. Количество строк должно быть больше нуля!");
            return;
        }

        System.out.print("Введите количество столбцов: ");
        int columns = scanner.nextInt();

        if (columns < 1) {
            System.out.println("Ошибка. Количество столбцов должно быть больше нуля!");
            return;
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        ArrayList<Integer> resultArray = getFilteredElements(matrix);
        double average = calculateAverage(resultArray);

        System.out.println("Динамический массив из элементов, удовлетворяющих условию:");
        System.out.println(resultArray);
        System.out.println("Среднее арифметическое: " + average);
    }

    public static ArrayList<Integer> getFilteredElements(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int j = 1; j < columns; j += 2) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] % 2 != 0) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }

    public static double calculateAverage(ArrayList<Integer> array) {
        int sum = 0;
        int count = array.size();

        for (int num : array) {
            sum += num;
        }

        return (double) sum / count;
    }
}