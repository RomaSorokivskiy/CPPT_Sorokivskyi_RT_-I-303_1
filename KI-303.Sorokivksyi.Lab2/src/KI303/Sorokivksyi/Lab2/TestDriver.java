package KI303.Sorokivksyi.Lab2;

/**
 * Клас Driver для тестування класу Television.
 *
 * @author Ваша_Ім'я
 * @version 1.0
 */
public class TestDriver {

    public static void main(String[] args) {
        Television tv = new Television();

        tv.turnOn();
        tv.changeChannel(5);
        tv.increaseVolume();
        tv.showStatus();
        tv.mute();
        tv.decreaseVolume();
        tv.showStatus();
        tv.turnOff();

        tv.closeLog();
    }
}
