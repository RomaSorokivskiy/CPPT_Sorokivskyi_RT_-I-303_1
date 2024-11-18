package KI303.Sorokivskyi.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Абстрактний клас Television представляє базову модель телевізора.
 * Містить екран, пульт дистанційного керування та динамік.
 *
 * @author Roman
 * @version 1.0
 */
public abstract class Television {

    // Поля класу (складові частини)
    protected Screen screen;
    protected RemoteControl remoteControl;
    protected Speaker speaker;

    protected boolean isOn;
    protected int currentChannel;
    protected int volumeLevel;

    // Лог-файл
    protected FileWriter logWriter;

    /**
     * Конструктор з параметрами.
     *
     * @param screen об'єкт екрану
     * @param remoteControl об'єкт пульта дистанційного керування
     * @param speaker об'єкт динаміка
     */
    public Television(Screen screen, RemoteControl remoteControl, Speaker speaker) {
        this.screen = screen;
        this.remoteControl = remoteControl;
        this.speaker = speaker;
        this.isOn = false;
        this.currentChannel = 1;
        this.volumeLevel = 10;

        try {
            logWriter = new FileWriter("television_log.txt", true);
            log("Телевізор створено.");
        } catch (IOException e) {
            System.err.println("Помилка при створенні файлу для логування: " + e.getMessage());
        }
    }

    /**
     * Конструктор без параметрів.
     */
    public Television() {
        this(new Screen("LED", 55), new RemoteControl("Sony"), new Speaker(10));
    }

    // Абстрактний метод, який повинен бути реалізований в підкласах
    public abstract void showSmartFeatures();

    // Звичайні методи класу
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            log("Телевізор увімкнено.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            log("Телевізор вимкнено.");
        }
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            currentChannel = newChannel;
            log("Канал змінено на: " + currentChannel);
        }
    }

    public void increaseVolume() {
        if (isOn && volumeLevel < 100) {
            volumeLevel++;
            log("Збільшено гучність до: " + volumeLevel);
        }
    }

    public void decreaseVolume() {
        if (isOn && volumeLevel > 0) {
            volumeLevel--;
            log("Зменшено гучність до: " + volumeLevel);
        }
    }

    public void showStatus() {
        if (isOn) {
            System.out.printf("Телевізор увімкнено. Канал: %d, Гучність: %d\n", currentChannel, volumeLevel);
            log("Статус телевізора показано на екрані.");
        } else {
            System.out.println("Телевізор вимкнено.");
            log("Статус телевізора показано на екрані.");
        }
    }

    /**
     * Завершення роботи з лог-файлом.
     */
    public void closeLog() {
        try {
            if (logWriter != null) {
                log("Роботу з телевізором завершено.");
                logWriter.close();
            }
        } catch (IOException e) {
            System.err.println("Помилка при закритті файлу логування: " + e.getMessage());
        }
    }

    // Приватний метод для логування дій у файл
    void log(String message) {
        try {
            if (logWriter != null) {
                logWriter.write(LocalDateTime.now() + ": " + message + "\n");
            }
        } catch (IOException e) {
            System.err.println("Помилка запису до файлу: " + e.getMessage());
        }
    }
}
