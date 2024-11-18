package KI303.Sorokivskyi.Lab4;
import java.io.*;
import java.util.Scanner;

/**
 * Клас для обчислення математичного виразу.
 * Залежно від варіанту обчислюється вираз y = cos(x) / tg(2x).
 */
public class MathExpression {

    /**
     * Обчислює значення виразу y = cos(x) / tg(2x).
     * @param x значення аргументу x.
     * @return результат обчислення cos(x) / tg(2x).
     * @throws IllegalArgumentException якщо tg(2x) = 0 або не визначено.
     */
    public static double calculate(double x) throws IllegalArgumentException {
        double tan2x = Math.tan(2 * x);
        if (tan2x == 0) {
            throw new IllegalArgumentException("Невизначеність: tg(2x) не існує, коли tg(2x) = 0.");
        }
        return Math.cos(x) / tan2x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x;

        // Введення значення x
        System.out.print("Введіть значення x: ");
        x = scanner.nextDouble();

        try {
            // Обчислення виразу
            double result = calculate(x);

            // Запис результату в файл
            FileWriter writer = new FileWriter("result.txt");
            writer.write("Результат обчислення cos(" + x + ") / tg(2*" + x + ") = " + result);
            writer.close();
            System.out.println("Результат обчислення cos(" + x + ") / tg(2*" + x + ") = " + result);
            System.out.println("Результат обчислення записано в файл result.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка при записі в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
