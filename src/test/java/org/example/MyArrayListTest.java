package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @AfterEach
    void tearDown() {
        list.clear();
    }

    @Test
    void add_whenElementsAdded_thenGetReturnsCorrectValues() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void add_whenAddAtIndex_thenElementsInsertedCorrectly() {
        list.add(0);
        list.add(2);
        list.add(1, 1);

        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void remove_whenValidIndex_thenElementRemovedCorrectly() {
        list.add(5);
        list.add(10);
        list.remove(0);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void clear_whenCalled_thenListIsEmpty() {
        list.add(1);
        list.add(2);
        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void sort_whenCalled_thenListIsSorted() {
        list.add(5);
        list.add(3);
        list.add(8);
        list.sort();

        assertEquals(3, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(8, list.get(2));
    }

    @Test
    void add_whenInvalidIndex_thenThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 5));
    }

    @Test
    void remove_whenInvalidIndex_thenThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void get_whenInvalidIndex_thenThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @ParameterizedTest
    @MethodSource("provideDataForAddAtIndex")
    void add_whenValidIndexParameterized_thenElementsInsertedCorrectly(int index, Integer element, Integer[] expected) {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(index, element);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i), "Element at index " + i + " mismatch.");
        }
    }

    static Stream<Arguments> provideDataForAddAtIndex() {
        return Stream.of(
                Arguments.of(0, 99, new Integer[]{99, 1, 2, 3}),
                Arguments.of(2, 88, new Integer[]{1, 2, 88, 3}),
                Arguments.of(3, 77, new Integer[]{1, 2, 3, 77})
        );
    }

    @Test
    void toString_whenListNotEmpty_thenCorrectStringReturned() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void toString_whenListEmpty_thenReturnEmptyBrackets() {
        assertEquals("[]", list.toString());
    }

    @Test
    void size_whenElementsAddedAndRemoved_thenSizeIsCorrect() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

}
