package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAddAndGet() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(0);
        list.add(2);
        list.add(1, 1);

        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testRemove() {
        list.add(5);
        list.add(10);
        list.remove(0);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testSort() {
        list.add(5);
        list.add(3);
        list.add(8);
        list.sort();

        assertEquals(3, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(8, list.get(2));
    }

    @Test
    void testAddInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 5));
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testGetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

}