# main.py

from tuner_tv import TunerTelevision


def main():
    """Точка входу в програму."""
    # Створення екземпляра базового телевізора
    tv = TunerTelevision("Samsung", 55, 2022, ["BBC", "CNN", "National Geographic"])

    # Виведення інформації про телевізор
    print(tv.display_info())

    # Додавання нового каналу
    print(tv.add_channel("Discovery"))

    # Виведення оновленої інформації
    print(tv.display_info())

    # Видалення каналу
    print(tv.remove_channel("BBC"))

    # Виведення інформації після видалення
    print(tv.display_info())

    # Включення телевізора
    print(tv.turn_on())

    # Вимкнення телевізора
    print(tv.turn_off())


if __name__ == "__main__":
    main()
