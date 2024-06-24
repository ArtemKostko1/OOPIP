import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матриц: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Ошибка. Размерность матрица должна быть больше нуля!");
            return;
        }

        int[][] A = createMatrixA(n);
        int[][] B = createMatrixB(n);

        int sumA = calculateDiagonalSum(A);
        int sumB = calculateDiagonalSum(B);

        System.out.println("Матрица A:");
        printMatrix(A);
        System.out.println("Сумма элементов главной диагонали матрицы A: " + sumA);

        System.out.println("Матрица B:");
        printMatrix(B);
        System.out.println("Сумма элементов главной диагонали матрицы B: " + sumB);
    }

    public static int[][] createMatrixA(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 3 * i * j - 3;
            }
        }

        return matrix;
    }

    public static int[][] createMatrixB(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 2 * i * j - 2;
            }
        }

        return matrix;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}