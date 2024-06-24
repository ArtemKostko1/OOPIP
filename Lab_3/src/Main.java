public class Main {
    public static void main(String[] args) {
        // Задача 1
        int N = 0;
        int i = 1;

        System.out.println("Задача 1: Вычисление a_i и b_i для каждого i от 1 до 30:");
        while (i <= 30) {
            int ai, bi;
            if (i % 2 != 0) {
                ai = i;
                bi = i * i;
                System.out.println("i = " + i + " (нечётное), a_i = " + ai + ", b_i = " + bi);
            } else {
                ai = i / 2;
                bi = i * i * i;
                System.out.println("i = " + i + " (чётное), a_i = " + ai + ", b_i = " + bi);
            }
            N += Math.pow(ai - bi, 2);
            i++;
        }
        System.out.println("Ответ = " + N);

        // Задача 2
        double epsilon = 1e-3;
        double sum = 0;
        int n = 1;
        double term;

        System.out.println("\nЗадача 2: Найти сумму ряда с точностью до ε = 10^-3:");
        do {
            term = Math.pow(1.0 / 2, n) + Math.pow(1.0 / 3, n);
            sum += term;
            n++;
        } while (term >= epsilon);
        System.out.println("Сумма ряда = " + sum);

        // Задача 3
        double A = 0;
        double B = Math.PI / 2;
        int M = 20;
        double H = (B - A) / M;

        System.out.println("\nЗадача 3: Вычисление значений функции y = sin(x) - cos(x):");
        for (int j = 0; j <= M; j++) {
            double X = A + j * H;
            double y = Math.sin(X) - Math.cos(X);
            System.out.println("X" + j + " = " + X + ", y = " + y);
        }
    }
}
