package org.example;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void sortingIntegersInNaturalOrder() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);

        Utils.quickSort(list);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(5, list.get(2));
    }

    @Test
    void sortingStringsInNaturalOrder() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Orange");

        Utils.quickSort(list);

        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Orange", list.get(2));
    }

    @Test
    void sortingIntegersInReverseOrder() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        Utils.quickSort(list, Comparator.reverseOrder());

        assertEquals(5, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    void sortingStringsByLength() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Pear");
        list.add("Apple");
        list.add("Kiwi");

        Utils.quickSort(list, Comparator.comparingInt(String::length));

        assertEquals("Pear", list.get(0));
        assertEquals("Kiwi", list.get(1));
        assertEquals("Apple", list.get(2));
    }

    @Test
    void sortingEmptyListShouldNotFail() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertDoesNotThrow(() -> Utils.quickSort(list));
    }

    @Test
    void sortingSingleElementListShouldKeepOrder() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(42);

        Utils.quickSort(list);

        assertEquals(1, list.size());
        assertEquals(42, list.get(0));
    }

    @Test
    void addingAndGettingElementsFromArrayList() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Test");
        assertEquals("Test", list.get(0));
    }

    @Test
    void accessingInvalidIndexShouldThrowException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void sortingArrayListUsingDefaultQuickSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        list.quickSort();

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }
}
