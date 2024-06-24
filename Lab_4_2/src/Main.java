public class Main {
    public static void main(String[] args) {
        // Initialize a static 2D array (NxM)
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int N = matrix.length;
        int M = matrix[0].length;

        // Print the original matrix
        System.out.println("Исходная матрица:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        long product = 1;
        boolean foundOddColumn = false;

        // Find the product of elements in odd-numbered columns
        for (int j = 0; j < M; j += 2) { // j starts from 0 and increments by 2 to access odd columns
            for (int i = 0; i < N; i++) {
                product *= matrix[i][j];
                foundOddColumn = true;
            }
        }

        // If no odd columns are found (should not happen in this setup), set product to 0
        if (!foundOddColumn) {
            product = 0;
        }

        // Print the result
        System.out.println("Произведение элементов в нечетных столбцах: " + product);
    }
}
