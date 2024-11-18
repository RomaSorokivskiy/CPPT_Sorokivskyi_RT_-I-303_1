package KI303.Sorokivskyi.Lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Клас для реалізації полички для зберігання елементів типу T.
 * Включає методи для додавання, видалення елементів, а також пошуку максимального або мінімального елементу.
 *
 * @param <T> тип елементів, що зберігаються на поличці.
 */
public class Shelf<T extends Comparable<T>> {

    private List<T> items;

    // Конструктор, ініціалізує список елементів.
    public Shelf() {
        this.items = new ArrayList<>();
    }

    /**
     * Додає елемент на поличку.
     * @param item елемент для додавання.
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Видаляє елемент з полички.
     * @param item елемент для видалення.
     * @return true, якщо елемент успішно видалений, false - якщо елемент не знайдений.
     */
    public boolean remove(T item) {
        return items.remove(item);
    }

    /**
     * Знаходить максимальний елемент на поличці.
     * Використовується для непарних варіантів завдання.
     * @return максимальний елемент.
     * @throws IllegalStateException якщо поличка порожня.
     */
    public T getMax() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Поличка порожня.");
        }
        return Collections.max(items);
    }

    /**
     * Знаходить мінімальний елемент на поличці.
     * Використовується для парних варіантів завдання.
     * @return мінімальний елемент.
     * @throws IllegalStateException якщо поличка порожня.
     */
    public T getMin() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Поличка порожня.");
        }
        return Collections.min(items);
    }

    /**
     * Виводить всі елементи на поличці.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Поличка порожня.");
        } else {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        // Тест для чисел
        Shelf<Integer> integerShelf = new Shelf<>();
        integerShelf.add(10);
        integerShelf.add(20);
        integerShelf.add(5);
        integerShelf.add(15);

        System.out.println("Поличка з цілими числами:");
        integerShelf.displayItems();

        // Знайти мінімальне або максимальне значення в залежності від варіанту
        System.out.println("Максимум: " + integerShelf.getMax()); // Для непарного варіанту
        // System.out.println("Мінімум: " + integerShelf.getMin()); // Для парного варіанту

        // Тест для рядків
        Shelf<String> stringShelf = new Shelf<>();
        stringShelf.add("Banana");
        stringShelf.add("Apple");
        stringShelf.add("Cherry");

        System.out.println("\nПоличка з рядками:");
        stringShelf.displayItems();

        // Знайти мінімальне або максимальне значення в залежності від варіанту
        System.out.println("Максимум: " + stringShelf.getMax()); // Для непарного варіанту
        // System.out.println("Мінімум: " + stringShelf.getMin()); // Для парного варіанту
    }
}
