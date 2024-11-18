# tuner_tv.py

from base_tv import Television


class TunerTelevision(Television):
    """
    Клас Телевізор з тюнером, який розширює функціональність телевізора.

    Атрибути:
        brand (str): марка телевізора
        size (int): розмір екрану (в дюймах)
        year (int): рік випуску телевізора
        tuner_channels (list): список каналів, доступних через тюнер
    """

    def __init__(self, brand, size, year, tuner_channels=None):
        # Викликаємо конструктор базового класу
        super().__init__(brand, size, year)
        if tuner_channels is None:
            tuner_channels = []
        self.tuner_channels = tuner_channels

    def display_info(self):
        """Метод для виведення інформації про телевізор з тюнером."""
        basic_info = super().display_info()  # Виклик методу базового класу
        return f"{basic_info} Доступні канали через тюнер: {', '.join(self.tuner_channels)}."

    def add_channel(self, channel):
        """Метод для додавання каналу в тюнер."""
        self.tuner_channels.append(channel)
        return f"Канал {channel} додано в тюнер."

    def remove_channel(self, channel):
        """Метод для видалення каналу з тюнера."""
        if channel in self.tuner_channels:
            self.tuner_channels.remove(channel)
            return f"Канал {channel} видалено з тюнера."
        else:
            return f"Канал {channel} не знайдено."
