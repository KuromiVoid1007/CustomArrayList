package org.example;

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
    void sort();

    /**
     * Возвращает размер списка.
     *
     * @return количество элементов
     */
    int size();

    /**
     * Преобразует список в строку.
     *
     * @return строковое представление списка
     */
    @Override
    String toString();
}
