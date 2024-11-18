import os


def generate_zubchaty_list(size, fill_char):
    """
    Генерує зубчатий масив, де непарні рядки заповнені символом,
    а чітні - залишаються порожніми.

    :param size: Розмір квадратної матриці
    :param fill_char: Символ-заповнювач для заштрихованих смуг
    :return: Матриця (список списків) для зубчатої матриці
    """
    matrix = []

    for i in range(size):
        row = []
        if i % 2 != 0:  # Непарні рядки (i % 2 != 0) заповнені символами
            row = [fill_char] * size
        else:  # Чітні рядки залишаються порожніми
            row = [' '] * size
        matrix.append(row)

    return matrix


def print_matrix(matrix):
    """
    Виводить матрицю на екран.

    :param matrix: Матриця для виведення
    """
    for row in matrix:
        print(" ".join(row))


def save_to_file(matrix, filename):
    """
    Зберігає матрицю у файл.

    :param matrix: Матриця для збереження
    :param filename: Ім'я файлу для збереження
    """
    try:
        with open(filename, 'w') as file:
            for row in matrix:
                file.write(" ".join(row) + "\n")
        print(f"Масив збережено у файл: {filename}")
    except IOError as e:
        print(f"Помилка запису у файл: {e}")


def main():
    """
    Основна функція програми.
    Запитує розмір матриці та символ-заповнювач, генерує матрицю і зберігає її у файл.
    """
    try:
        # Введення розміру матриці
        size = int(input("Введіть розмір квадратної матриці: "))
        if size <= 0:
            print("Розмір матриці має бути додатнім числом.")
            return

        # Введення символу-заповнювача
        fill_char = input("Введіть символ-заповнювач: ")
        if len(fill_char) != 1:
            print("Помилка: необхідно ввести рівно один символ.")
            return

        # Генерація зубчатого масиву
        matrix = generate_zubchaty_list(size, fill_char)

        # Виведення матриці на екран
        print("\nСформована зубча матриця:")
        print_matrix(matrix)

        # Збереження у файл
        save_to_file(matrix, "zubchaty_list_output.txt")

    except ValueError:
        print("Виникла помилка при введенні розміру матриці. Будь ласка, введіть ціле число.")


if __name__ == "__main__":
    main()
