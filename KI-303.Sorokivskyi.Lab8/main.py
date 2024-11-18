import math
import struct


def calculate_expression(x):
    """
    Обчислює вираз y = cos(x) / tan(2x) для заданого x.

    :param x: значення для обчислення виразу
    :return: результат обчислення
    """
    try:
        # Перевірка на можливу помилку ділення на нуль
        tan_2x = math.tan(2 * x)
        if tan_2x == 0:
            raise ValueError("Помилка: знаменник дорівнює нулю (tan(2x) = 0).")

        result = math.cos(x) / tan_2x
        return result
    except ValueError as e:
        print(f"Помилка: {e}")
        return None


def save_to_text_file(filename, data):
    """
    Зберігає дані у текстовому файлі.

    :param filename: ім'я файлу для збереження
    :param data: дані, які потрібно записати
    """
    try:
        with open(filename, 'w') as file:
            file.write(f"Результати обчислення виразу:\n{data}\n")
        print(f"Результати збережено у текстовий файл: {filename}")
    except IOError as e:
        print(f"Помилка запису у файл: {e}")


def save_to_binary_file(filename, data):
    """
    Зберігає дані у двійковому файлі.

    :param filename: ім'я файлу для збереження
    :param data: дані, які потрібно записати
    """
    try:
        with open(filename, 'wb') as file:
            # Запис результату як числа з плаваючою комою в двійковому форматі
            file.write(struct.pack('f', data))
        print(f"Результати збережено у двійковий файл: {filename}")
    except IOError as e:
        print(f"Помилка запису у файл: {e}")


def main():
    """
    Основна функція програми. Зчитує значення x, обчислює вираз і зберігає результат у файли.
    """
    try:
        # Введення значення x
        x = float(input("Введіть значення x: "))

        # Обчислення виразу
        result = calculate_expression(x)

        if result is not None:
            # Виведення результату на екран
            print(f"Результат обчислення для x = {x}: y = {result}")

            # Збереження результату в текстовий файл
            save_to_text_file('result.txt', result)

            # Збереження результату в двійковий файл
            save_to_binary_file('result.bin', result)

    except ValueError:
        print("Виникла помилка: введіть коректне число для x.")


if __name__ == "__main__":
    main()
