import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас Lab1ПрізвищеГрупа демонструє створення зубчатого масиву
 * з горизонтальними заштрихованими смугами в квадратній матриці.
 *
 * @author Ваша_Ім'я
 * @version 1.0
 */
public class Lab1Sorokivskyi303 {

    /**
     * Метод main є точкою входу в програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру квадратної матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера після вводу числа

        // Введення символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String fillInput = scanner.nextLine();

        // Перевірка введеного символу
        if (fillInput.length() != 1) {
            System.out.println("Помилка: необхідно ввести рівно один символ.");
            return;
        }
        char fillChar = fillInput.charAt(0);

        // Генерація зубчатого масиву
        char[][] jaggedArray = generateJaggedArray(size, fillChar);

        // Виведення масиву на екран
        System.out.println("Сформований зубчатий масив:");
        printJaggedArray(jaggedArray);

        // Запис масиву у текстовий файл
        saveArrayToFile(jaggedArray, "jagged_array_output.txt");

        scanner.close();
    }

    /**
     * Генерує зубчатий масив із горизонтальними заштрихованими смугами (заповнюються лише парні рядки).
     *
     * @param size розмір квадратної матриці
     * @param fillChar символ-заповнювач для заштрихованих смуг
     * @return зубчатий масив з горизонтальними смугами
     */
    public static char[][] generateJaggedArray(int size, char fillChar) {
        char[][] jaggedArray = new char[size][];

        for (int i = 0; i < size; i++) {
            // Тепер парні рядки (з індексом i % 2 != 0) будуть зафарбовані
            if (i % 2 != 0) {
                jaggedArray[i] = new char[size];
                // Заповнення рядка символом
                for (int j = 0; j < size; j++) {
                    jaggedArray[i][j] = fillChar;
                }
            } else {
                // Непарні рядки залишаються пустими
                jaggedArray[i] = new char[0];
            }
        }
        return jaggedArray;
    }

    /**
     * Виводить зубчатий масив на екран.
     *
     * @param array зубчатий масив для виведення
     */
    public static void printJaggedArray(char[][] array) {
        for (char[] row : array) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Зберігає зубчатий масив у текстовий файл.
     *
     * @param array зубчатий масив для збереження
     * @param filename ім'я файлу для збереження
     */
    public static void saveArrayToFile(char[][] array, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (char[] row : array) {
                for (char c : row) {
                    writer.write(c + " ");
                }
                writer.write(System.lineSeparator());
            }
            System.out.println("Масив збережено у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
