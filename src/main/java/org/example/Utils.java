package org.example;

import java.util.Comparator;

public class Utils {
    /**
     * Быстрая сортировка (QuickSort) для списка с элементами, реализующими Comparable.
     *
     * @param list список для сортировки
     * @param <T>  тип элементов, реализующих Comparable
     */
    public static <T extends Comparable<? super T>> void quickSort(MyList<T> list) {

        if (list == null || list.size() <= 1) return;

        quickSort(list, 0, list.size() - 1, null);

    }

    /**
     * Быстрая сортировка (QuickSort) с использованием Comparator.
     *
     * @param list       список для сортировки
     * @param comparator компаратор для сравнения элементов
     * @param <T>        тип элементов в списке
     */
    public static <T> void quickSort(MyList<T> list, Comparator<? super T> comparator) {

        if (list == null || list.size() <= 1) return;

        quickSort(list, 0, list.size() - 1, comparator);

    }

    /**
     * Внутренний метод для рекурсивной сортировки.
     *
     * @param list       список
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор (может быть null, тогда используется Comparable)
     */
    private static <T> void quickSort(MyList<T> list, int low, int high, Comparator<? super T> comparator) {

        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }

    }

    /**
     * Разделение списка для QuickSort.
     *
     * @return индекс опорного элемента
     */
    private static <T> int partition(MyList<T> list, int low, int high, Comparator<? super T> comparator) {

        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {

            boolean shouldSwap;

            if (comparator != null) {
                shouldSwap = comparator.compare(list.get(j), pivot) <= 0;
            } else {
                @SuppressWarnings("unchecked")
                Comparable<? super T> comparable = (Comparable<? super T>) list.get(j);
                shouldSwap = comparable.compareTo(pivot) <= 0;
            }

            if (shouldSwap) {
                i++;
                swap(list, i, j);
            }

        }

        swap(list, i + 1, high);

        return i + 1;

    }

    /**
     * Обмен элементов местами.
     */
    private static <T> void swap(MyList<T> list, int i, int j) {

        if (i == j) return;

        T temp = list.get(i);
        list.remove(i);
        list.add(i, list.get(j - 1));
        list.remove(j);
        list.add(j, temp);

    }
}
