package KI303.Sorokivskyi.Lab3;
/**
 * Клас SmartDriver для тестування класу SmartTelevision.
 *
 * @author Roman
 * @version 1.0
 */
public class SmartDriver {

    public static void main(String[] args) {
        // Створення об'єктів екрану, пульта та динаміка
        Screen screen = new Screen("OLED", 65);
        RemoteControl remote = new RemoteControl("Samsung");
        Speaker speaker = new Speaker(15);

        // Створення смарт-телевізора
        SmartTelevision smartTV = new SmartTelevision(screen, remote, speaker);

        // Тестування функціональності
        smartTV.turnOn();
        smartTV.changeChannel(10);
        smartTV.increaseVolume();
        smartTV.showStatus();
        smartTV.connectToInternet();
        smartTV.browseWeb("https://www.youtube.com");
        smartTV.showSmartFeatures();
        smartTV.turnOff();
        smartTV.closeLog();
    }
}
