package KI303.Sorokivksyi.Lab2;

/**
 * Клас Screen представляє модель екрану телевізора.
 *
 * @author Roman
 * @version 1.0
 */
public class Screen {
    private String type;
    private int size;

    public Screen(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
