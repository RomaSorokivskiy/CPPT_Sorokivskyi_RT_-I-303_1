# base_tv.py

class Television:
    """
    Клас Телевізор, що містить основні характеристики телевізора.

    Атрибути:
        brand (str): марка телевізора
        size (int): розмір екрану (в дюймах)
        year (int): рік випуску телевізора
    """

    def __init__(self, brand, size, year):
        self.brand = brand
        self.size = size
        self.year = year

    def display_info(self):
        """Метод для виведення інформації про телевізор."""
        return f"Телевізор {self.brand}, розмір: {self.size} дюймів, рік випуску: {self.year}."

    def turn_on(self):
        """Метод для включення телевізора."""
        return f"{self.brand} телевізор включено."

    def turn_off(self):
        """Метод для вимкнення телевізора."""
        return f"{self.brand} телевізор вимкнено."
