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
    void addingElementsUpdatesListSize() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void insertingElementAtValidIndexShiftsElements() {
        list.add(0);
        list.add(2);
        list.add(1, 1);

        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void removingElementAtValidIndexUpdatesList() {
        list.add(5);
        list.add(10);
        list.remove(0);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void clearingListRemovesAllElements() {
        list.add(1);
        list.add(2);
        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void addingElementAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 5));
    }

    @Test
    void removingElementAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void gettingElementAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @ParameterizedTest
    @MethodSource("provideDataForAddAtIndex")
    void insertingElementsWithParametersUpdatesList(int index, Integer element, Integer[] expected) {
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
    void convertingListToStringReturnsValidFormat() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void convertingEmptyListToStringReturnsEmptyBrackets() {
        assertEquals("[]", list.toString());
    }

    @Test
    void sizeChangesAfterAddingAndRemovingElements() {
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
