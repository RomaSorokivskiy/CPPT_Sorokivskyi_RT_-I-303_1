package KI303.Sorokivskyi.Lab3;

/**
 * Клас SmartTelevision розширює абстрактний клас Television,
 * додає функції підключення до Інтернету.
 *
 * @author Roman
 * @version 1.0
 */
public class SmartTelevision extends Television implements InternetConnectable {

    private boolean isConnected;

    /**
     * Конструктор класу SmartTelevision.
     *
     * @param screen об'єкт екрану
     * @param remoteControl об'єкт пульта дистанційного керування
     * @param speaker об'єкт динаміка
     */
    public SmartTelevision(Screen screen, RemoteControl remoteControl, Speaker speaker) {
        super(screen, remoteControl, speaker);
        this.isConnected = false;
    }

    /**
     * Підключення до Інтернету.
     */
    @Override
    public void connectToInternet() {
        if (isOn && !isConnected) {
            isConnected = true;
            log("Підключено до Інтернету.");
            System.out.println("Підключено до Інтернету.");
        }
    }

    /**
     * Перегляд веб-сайтів.
     *
     * @param url URL веб-сайту
     */
    @Override
    public void browseWeb(String url) {
        if (isOn && isConnected) {
            log("Переглядається веб-сайт: " + url);
            System.out.println("Переглядається веб-сайт: " + url);
        } else {
            System.out.println("Не підключено до Інтернету.");
        }
    }

    /**
     * Показує смарт-функції телевізора.
     */
    @Override
    public void showSmartFeatures() {
        System.out.println("Показуються смарт-функції: YouTube, Netflix, Web Browser.");
        log("Показуються смарт-функції.");
    }
}
