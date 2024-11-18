package KI303.Sorokisvkyi.Lab5;
import java.io.*;
import java.util.Scanner;

/**
 * Клас для обчислення виразу y = cos(x) / tg(2x)
 * та збереження результату в текстовому та двійковому форматах.
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

    /**
     * Запис результату в текстовий файл.
     * @param filename ім'я файлу для запису.
     * @param result результат обчислення.
     */
    public static void writeToTextFile(String filename, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Результат обчислення cos(x) / tg(2x): " + result);
        } catch (IOException e) {
            System.out.println("Помилка при записі в текстовий файл: " + e.getMessage());
        }
    }

    /**
     * Запис результату в двійковий файл.
     * @param filename ім'я файлу для запису.
     * @param result результат обчислення.
     */
    public static void writeToBinaryFile(String filename, double result) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeDouble(result);
        } catch (IOException e) {
            System.out.println("Помилка при записі в двійковий файл: " + e.getMessage());
        }
    }

    /**
     * Читання результату з текстового файлу.
     * @param filename ім'я файлу для читання.
     * @return прочитане значення.
     */
    public static double readFromTextFile(String filename) {
        double result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] parts = line.split(": ");
            result = Double.parseDouble(parts[1]);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Помилка при читанні з текстового файлу: " + e.getMessage());
        }
        return result;
    }

    /**
     * Читання результату з двійкового файлу.
     * @param filename ім'я файлу для читання.
     * @return прочитане значення.
     */
    public static double readFromBinaryFile(String filename) {
        double result = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            result = dis.readDouble();
        } catch (IOException e) {
            System.out.println("Помилка при читанні з двійкового файлу: " + e.getMessage());
        }
        return result;
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

            // Запис результату в текстовий та двійковий файли
            String textFile = "result.txt";
            String binaryFile = "result.bin";
            writeToTextFile(textFile, result);
            writeToBinaryFile(binaryFile, result);
            System.out.println("Результат обчислення записано в файли.");

            // Читання результатів з файлів
            double resultFromText = readFromTextFile(textFile);
            double resultFromBinary = readFromBinaryFile(binaryFile);

            System.out.println("Результат з текстового файлу: " + resultFromText);
            System.out.println("Результат з двійкового файлу: " + resultFromBinary);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
