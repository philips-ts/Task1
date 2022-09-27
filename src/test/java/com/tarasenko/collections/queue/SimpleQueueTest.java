package com.tarasenko.collections.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


class SimpleQueueTest {

    SimpleQueue<Integer> simpleQueue;

    @BeforeEach
    void setUp(){
        simpleQueue = new SimpleQueue<>();
        simpleQueue.add(10);
        simpleQueue.add(40);
        simpleQueue.add(30);
        simpleQueue.add(50);
        simpleQueue.add(40);
        simpleQueue.add(70);
    }

    @Test
    void size_ShouldReturnCorrectSizeOfQueue() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();

        Assertions.assertEquals(simpleQueue.size(), 0);

        final int numberToAdd = 1000;
        for (int i = 0; i < 1000; i++) {
            simpleQueue.add(i);
        }

        Assertions.assertEquals(simpleQueue.size(), numberToAdd);
    }

    @Test
    void isEmpty_ShouldReturnTrue_whenQueueIsEmpty_otherwiseFalse() {
        SimpleQueue<Integer> emptyQueue = new SimpleQueue<>();
        Assertions.assertTrue(emptyQueue.isEmpty());
        emptyQueue.add(10);
        Assertions.assertFalse(emptyQueue.isEmpty());
    }

    @Test
    void contains_ShouldReturnTrue_whenQueueContainsElement_otherwiseFalse() {
        Assertions.assertTrue(simpleQueue.contains(30));
        Assertions.assertTrue(simpleQueue.contains(10));
        Assertions.assertFalse(simpleQueue.contains(100));
        Assertions.assertFalse(simpleQueue.contains(null));
    }

    @Test
    void addShouldAddElements_whenInputParameterIsCorrectObject() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        final int numberToAdd = 100;
        Integer[] actualArray = new Integer[numberToAdd];
        for (int i = 0; i < numberToAdd; i++) {
            actualArray[i] = i;
            simpleQueue.add(i);
        }

        Assertions.assertEquals(simpleQueue.size(), numberToAdd);
        for (int i = 0; i < actualArray.length; i++) {
            Assertions.assertEquals(simpleQueue.poll(), actualArray[i]);
        }
    }

    @Test
    void addShouldAddNull_whenInputParameterIsNull() {
        SimpleQueue<Integer> testQueue = new SimpleQueue<>();
        final int numberToAdd = 10;
        for (int i = 0; i < numberToAdd; i++) {
            testQueue.add(null);
        }

        Assertions.assertEquals(testQueue.size(), numberToAdd);
        Assertions.assertEquals(testQueue.size(), numberToAdd);
        for (int i = numberToAdd - 1; i  >= 0; i--) {
            Assertions.assertNull(testQueue.poll());
        }
    }

    @Test
    void removeShouldRemoveByObject() {
        simpleQueue.remove(30);
        Assertions.assertEquals(simpleQueue.size(), 5);

        simpleQueue.remove(50);
        Assertions.assertEquals(simpleQueue.size(), 4);
    }

    @Test
    void remove_ShouldRemoveFirstElement_whenHasNoParameters() {
        simpleQueue.remove();
        Assertions.assertEquals(simpleQueue.size(), 5);
    }

    @Test
    void remove_ShouldThrowsException_whenQueueIsEmpty() {
        SimpleQueue<Integer> emptyQueue = new SimpleQueue<>();
        Assertions.assertThrows(NoSuchElementException.class, emptyQueue::remove);
    }

    @Test
    void containsAll_ShouldReturnTrue_whenInputCollectionIsContained() {
        List<Integer> collection = List.of(10, 30, 70);
        Assertions.assertTrue(simpleQueue.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotContained() {
        List<Integer> collection = List.of(5, 15, 25);
        Assertions.assertFalse(simpleQueue.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotPartiallyContained() {
        List<Integer> collection = List.of(20, 30, 100);
        Assertions.assertFalse(simpleQueue.containsAll(collection));
    }

    @Test
    void clear_shouldClearQueue() {
        simpleQueue.clear();
        Assertions.assertEquals(simpleQueue.size(), 0);
    }

    @Test
    void offer_ShouldAddsElementAsTheTailOfQueue() {
        SimpleQueue<Integer> emptyQueue = new SimpleQueue<>();
        emptyQueue.offer(15);
        emptyQueue.offer(22);
        Assertions.assertEquals(emptyQueue.size(), 2);
        Assertions.assertEquals(emptyQueue.poll(), 15);
        Assertions.assertEquals(emptyQueue.poll(), 22);
    }

    @Test
    void poll_ShouldRemovesAndReturnsFirstElementFromQueue() {
        Assertions.assertEquals(simpleQueue.poll(), 10);
        Assertions.assertEquals(simpleQueue.poll(), 40);
        Assertions.assertEquals(simpleQueue.poll(), 30);

        Assertions.assertEquals(simpleQueue.size(), 3);
    }

    @Test
    void poll_ShouldReturnNull_whenQueueIsEmpty() {
        SimpleQueue<Integer> emptyQueue = new SimpleQueue<>();
        Assertions.assertNull(emptyQueue.poll());
    }

    @Test
    void element_ShouldReturnsTheFirstElementOfQueue() {
        Assertions.assertEquals(simpleQueue.element(), 10);
        simpleQueue.remove();
        Assertions.assertEquals(simpleQueue.element(), 40);
    }

    @Test
    void peek_ShouldRetrievesTheFirstElementOfQueue_thenQueueIsNotEmpty() {
        Assertions.assertEquals(simpleQueue.peek(), 10);
        simpleQueue.remove();
        Assertions.assertEquals(simpleQueue.peek(), 40);
    }

    @Test
    void peek_ShouldReturnsNull_whenQueueIsEmpty() {
        SimpleQueue<Integer> emptyQueue = new SimpleQueue<>();
        Assertions.assertNull(emptyQueue.peek());

    }

    @Test
    void toArray_ShouldReturnCorrectArrayOfElements_whenNoInputParameters() {
        Object[] expectedArray = simpleQueue.toArray();

        Assertions.assertEquals(expectedArray.length, 6);
        Assertions.assertEquals(expectedArray[0], 10);
        Assertions.assertEquals(expectedArray[1], 40);
        Assertions.assertEquals(expectedArray[2], 30);
        Assertions.assertEquals(expectedArray[3], 50);
        Assertions.assertEquals(expectedArray[4], 40);
        Assertions.assertEquals(expectedArray[5], 70);
    }

    @Test
    void toArray_ShouldThrowsException_whenInputIsArrayOrNull() {
        Integer[] array = new Integer[simpleQueue.size()];
        Assertions.assertThrows(UnsupportedOperationException.class, () -> simpleQueue.toArray(array));
    }

    @Test
    void iterator_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> simpleQueue.iterator());
    }

    @Test
    void removeAll_ShouldThrowsUnsupportedOperationException_whenInputIsQueueOrNull() {
        List<Integer> testIntegerCollection = List.of(10, 40);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> simpleQueue.removeAll(testIntegerCollection));
    }

    @Test
    void retainAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionOrNull() {
        Collection<Integer> collection = Collections.singletonList(500);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> simpleQueue.retainAll(collection));
    }

    @Test
    void addAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionWithIndex() {
        List<Integer> testIntegerCollection = List.of(10, 40);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> simpleQueue.addAll(testIntegerCollection));
    }
}
