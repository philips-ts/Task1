package com.tarasenko.collections.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class TreeSetImplTest {

    TreeSetImpl<Integer> testTreeSet;

    @BeforeEach
    void setUp(){
        testTreeSet = new TreeSetImpl<>();
        testTreeSet.add(10);
        testTreeSet.add(40);
        testTreeSet.add(30);
        testTreeSet.add(50);
        testTreeSet.add(40);
        testTreeSet.add(70);
    }

    @Test
    void size_ShouldReturnCorrectSizeOfSet() {
        Assertions.assertEquals(testTreeSet.size(), 5);
    }

    @Test
    void isEmpty_ShouldReturnTrue_whenSetIsEmpty_otherwiseFalse() {
        TreeSetImpl<Integer> emptyTreeSet = new TreeSetImpl<>();
        Assertions.assertTrue(emptyTreeSet.isEmpty());
        emptyTreeSet.add(10);
        Assertions.assertFalse(emptyTreeSet.isEmpty());
    }

    @Test
    void clear_shouldClearSet() {
        testTreeSet.clear();
        Assertions.assertEquals(testTreeSet.size(), 0);
    }

    @Test
    void containsAll_ShouldReturnTrue_whenInputCollectionIsContained_otherwiseFalse() {
        List<Integer> collection = List.of(10, 30, 70);
        Assertions.assertTrue(testTreeSet.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotContained_otherwiseFalse() {
        List<Integer> collection = List.of(5, 15, 25);
        Assertions.assertFalse(testTreeSet.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotPartiallyContained_otherwiseFalse() {
        List<Integer> collection = List.of(20, 30, 100);
        Assertions.assertFalse(testTreeSet.containsAll(collection));
    }

    @Test
    void addShouldAddElements_whenInputParameterIsCorrectObject() {
        TreeSetImpl<Integer> testSet = new TreeSetImpl<>();
        final int numberToAdd = 100;
        Integer[] actualArray = new Integer[numberToAdd];
        for (int i = 0; i < numberToAdd; i++) {
            actualArray[i] = i;
            testSet.add(i);
        }

        Assertions.assertEquals(testSet.size(), numberToAdd);
        for (int i = 0; i < actualArray.length; i++) {
            Assertions.assertTrue(testSet.contains(actualArray[i]));
        }
    }

    @Test
    void addShouldThrowsException_whenInputParameterIsNull() {
        Assertions.assertThrows(Exception.class, () -> testTreeSet.add(null));
    }

    @Test
    void remove_ShouldRemoveFromSet() {
        testTreeSet.remove(30);
        Assertions.assertEquals(testTreeSet.size(), 4);
    }

    @Test
    void remove_ShouldThrowsException_whenParameterIsNull() {
        TreeSetImpl<Integer> emptySet = new TreeSetImpl<>();
        Assertions.assertThrows(Exception.class, () -> emptySet.remove(null));
    }


    @Test
    void containsAll_ShouldReturnTrue_whenInputCollectionIsContained() {
        List<Integer> collection = List.of(10, 30, 70);
        Assertions.assertTrue(testTreeSet.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotContained() {
        List<Integer> collection = List.of(5, 15, 25);
        Assertions.assertFalse(testTreeSet.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotPartiallyContained() {
        List<Integer> collection = List.of(20, 30, 100);
        Assertions.assertFalse(testTreeSet.containsAll(collection));
    }


    @Test
    void addAll() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.addAll(null));
    }

    @Test
    void toArray() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.toArray());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.toArray(new Integer[0]));
    }

    @Test
    void iterator() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.iterator());
    }

    @Test
    void retainAll() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.retainAll(null));
    }

    @Test
    void removeAll() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeSet.removeAll(null));
    }
}
