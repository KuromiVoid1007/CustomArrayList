package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация динамического списка на основе массива.
 * Поддерживает все операции, определённые в интерфейсе MyList.
 *
 * @param <T> тип элементов в списке
 */
public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    /**
     * Создаёт пустой список с начальной ёмкостью по умолчанию.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Создаёт пустой список с указанной начальной ёмкостью.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {

        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;

    }

    @Override
    public void add(T element) {

        ensureCapacity();
        elements[size++] = element;

    }

    @Override
    public void add(int index, T element) {

        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;

    }

    @Override
    public T get(int index) {

        checkIndex(index);

        return elements[index];

    }

    @Override
    public void remove(int index) {

        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;

    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;

    }

    @Override
    public void sort(Comparator<? super T> comparator) {

        if (size > 1) {
            Arrays.sort(elements, 0, size, comparator);
        }

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        }
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
     * Увеличивает ёмкость списка, если необходимо.
     */
    private void ensureCapacity() {

        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }

    }

    /**
     * Проверяет, допустим ли индекс для операций доступа.
     *
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

    }

    /**
     * Проверяет, допустим ли индекс для операций добавления.
     *
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    private void checkIndexForAdd(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

    }
}
