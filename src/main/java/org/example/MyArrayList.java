package org.example;

import java.util.Arrays;

/**
 * Реализация собственной версии списка на основе массива.
 * @param <T> тип элементов, которые хранятся в списке
 */
public class MyArrayList<T extends Comparable<T>> {

    private T[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;


    /**
     * Конструктор по умолчанию.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {

        elements = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;

    }


    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {

        ensureCapacity();

        elements[size++] = element;

    }


    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   позиция, куда нужно вставить элемент
     * @param element элемент для вставки
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void add(int index, T element) {

        checkIndexForAdd(index);

        ensureCapacity();

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;

        size++;

    }


    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public T get(int index) {

        checkIndex(index);

        return elements[index];

    }


    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс удаляемого элемента
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void remove(int index) {

        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;

    }


    /**
     * Очищает весь список.
     */
    public void clear() {

        Arrays.fill(elements, 0, size, null);

        size = 0;

    }


    /**
     * Сортирует список по естественному порядку.
     */
    public void sort() {
        Arrays.sort(elements, 0, size);
    }


    /**
     * Возвращает текущий размер списка.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }


    /**
     * Преобразует список в строку.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();

    }


    /**
     * Увеличивает размер внутреннего массива при необходимости.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;

            elements = Arrays.copyOf(elements, newCapacity);
        }
    }


    /**
     * Проверяет допустимость индекса для доступа.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
    }


    /**
     * Проверяет допустимость индекса для добавления.
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона для вставки: " + index);
        }
    }

}

