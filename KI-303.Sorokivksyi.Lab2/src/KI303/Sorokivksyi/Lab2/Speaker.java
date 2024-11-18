package KI303.Sorokivksyi.Lab2;
/**
 * Клас Speaker представляє модель динаміка телевізора.
 *
 * @author Roman
 * @version 1.0
 */
public class Speaker {
    private int maxVolume;

    public Speaker(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }
}
