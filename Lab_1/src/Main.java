import java.util.Scanner;

public class Main {
    public static void calcX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число x: ");
        double x = scanner.nextDouble();

        double x_sq23 = 23 * x * x;
        double x69 = 3 * x_sq23;
        double x32 = 32 * x;
        double x23 = x_sq23 * x;
        double result1 = x23 + x69 + x32 + 8;
        System.out.println("Результат вычисления 23x^3 + 69x^2 + 32x + 8: " + result1);
        double result2 = -x23 + x69 - x32 + 8;
        System.out.println("Результат вычисления -23x^3 + 69x^2 - 32x + 8: " + result2);
    }

    public static void geometricProgression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первый член геометрической прогрессии b1: ");
        double b1 = scanner.nextDouble();
        double q = 1.0/15;
        System.out.println("Знаменатель прогрессии q: " + q);
        double sum = b1 * (1 - Math.pow(q, 14)) / (1 - q);
        System.out.println("Полученная сумма: " + sum);
    }

    public static void arithmeticProgression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a1: ");
        double a1 = scanner.nextDouble();
        System.out.println("Введите a100: ");
        double a100 = scanner.nextDouble();
        double d = (a100 - a1) / 99;
        System.out.println("Разность арифметической прогрессии: " + d);
        double a24 = a1 + d * 23;
        double sum = (a1 + a24) / 12;
        System.out.println("Сумма арифметической прогрессии от a1 до a24: " + sum);
    }

    public static void calcTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x1: ");
        int x1 = scanner.nextInt();
        System.out.println("Введите y1: ");
        int y1 = scanner.nextInt();
        System.out.println("Введите x2: ");
        int x2 = scanner.nextInt();
        System.out.println("Введите y2: ");
        int y2 = scanner.nextInt();
        System.out.println("Введите x3: ");
        int x3 = scanner.nextInt();
        System.out.println("Введите y3: ");
        int y3 = scanner.nextInt();
        double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double ac = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        System.out.println("Длина стороны AB: " + ab);
        System.out.println("Длина стороны BC: " + bc);
        System.out.println("Длина стороны AC: " + ac);
        double p = (ab + bc + ac) / 2;
        double area = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        double ah = 2 * area / ab;
        double bh = 2 * area / bc;
        double ch = 2 * area / ac;
        System.out.println("Длина высоты из вершины A: " + ah);
        System.out.println("Длина высоты из вершины B: " + bh);
        System.out.println("Длина высоты из вершины C: " + ch);
        double angleA = Math.acos((bc * bc + ab * ab - ac * ac) / (2 * bc * ab)) * 180 / Math.PI;
        double angleB = Math.acos((ac * ac + ab * ab - bc * bc) / (2 * ac * ab)) * 180 / Math.PI;
        double angleC = Math.acos((bc * bc + ac * ac - ab * ab) / (2 * bc * ac)) * 180 / Math.PI;
        System.out.println("Угол A: " + angleA);
        System.out.println("Угол B: " + angleB);
        System.out.println("Угол C: " + angleC);
        System.out.println("Площадь треугольника: " + area);
        System.out.println("Периметр треугольника: " + p * 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNumber;
        do {
            System.out.println("Задачи: ");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Вычислить уравнение");
            System.out.println("2. Геометрическая прогрессия");
            System.out.println("3. Арифметическая прогрессия");
            System.out.println("4. Вычислить параметры треугольника");
            System.out.println("0. Выйти из программы");
            System.out.println("--------------------------------------------------");
            System.out.println("Введите номер задачи от 1 до 4 или 0 для выхода: ");
            taskNumber = scanner.nextInt();

            switch (taskNumber) {
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                case 1:
                    calcX();
                    break;
                case 2:
                    geometricProgression();
                    break;
                case 3:
                    arithmeticProgression();
                    break;
                case 4:
                    calcTriangle();
                    break;
                default:
                    System.out.println("Ошибка. Номер задачи должен быть от 1 до 4 или 0 для выхода!");
            }
        } while (taskNumber != 0);
    }
}