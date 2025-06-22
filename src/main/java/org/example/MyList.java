package org.example;

import java.util.Comparator;

/**
 * Интерфейс для списка.
 *
 * @param <T> тип элементов в списке
 */
public interface MyList<T> {

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    void add(T element);

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   индекс вставки
     * @param element элемент для вставки
     */
    void add(int index, T element);

    /**
     * Возвращает элемент по индексу.
     *
     * @param index индекс элемента
     * @return элемент по индексу
     */
    T get(int index);

    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс удаляемого элемента
     */
    void remove(int index);

    /**
     * Очищает список.
     */
    void clear();

    /**
     * Сортирует список по естественному порядку.
     */
    void sort(Comparator<? super T> comparator);

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    int size();

    /**
     * Быстрая сортировка (QuickSort) списка.
     */
    default void quickSort() {
        sort(null);
    }

    /**
     * Быстрая сортировка (QuickSort) списка с использованием указанного компаратора.
     */
    default void quickSort(Comparator<? super T> comparator) {
        sort(comparator);
    }

    /**
     * Преобразует список в строку.
     *
     * @return строковое представление списка
     */
    @Override
    String toString();
}
