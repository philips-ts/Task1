package com.tarasenko.collections.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


class LinkedListImplTest {

    LinkedListImpl<Integer> integerTestList;

    @BeforeEach
    void setUp(){
        integerTestList = new LinkedListImpl<>();
        integerTestList.add(10);
        integerTestList.add(40);
        integerTestList.add(30);
        integerTestList.add(50);
        integerTestList.add(40);
        integerTestList.add(70);
    }

    @Test
    void addFirst_ShouldInsertElementAtBeginningOfThisList() {
        integerTestList.addFirst(15);
        Assertions.assertEquals(integerTestList.get(0), 15);
        
        integerTestList.addFirst(22);
        integerTestList.addFirst(35);

        Assertions.assertEquals(integerTestList.get(1), 22);
        Assertions.assertEquals(integerTestList.get(2), 15);
    }

    @Test
    void addLast_ShouldAppendsElementToTheEndOfList() {
        integerTestList.addLast(15);
        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 15);

        integerTestList.addLast(25);

        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 25);
    }

    @Test
    void offerFirst_ShouldInsertsElementAtTheFrontOfList() {
        integerTestList.addFirst(15);
        Assertions.assertEquals(integerTestList.get(0), 15);

        integerTestList.addFirst(22);
        integerTestList.addFirst(35);

        Assertions.assertEquals(integerTestList.get(1), 22);
        Assertions.assertEquals(integerTestList.get(2), 15);
    }

    @Test
    void offerLast_ShouldInsertsElementAtTheEndOfList() {
        integerTestList.addLast(15);
        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 15);

        integerTestList.addLast(25);

        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 25);
    }

    @Test
    void removeFirst_ShouldRemovesAndReturnsFirstElementFromList() {
        Assertions.assertEquals(integerTestList.removeFirst(), 10);
        Assertions.assertEquals(integerTestList.removeFirst(), 40);
        Assertions.assertEquals(integerTestList.removeFirst(), 30);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void removeFirst_ShouldThrowsException_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertThrows(NoSuchElementException.class, emptyList::removeFirst);
    }

    @Test
    void removeLast_ShouldRemovesAndReturnsTheLastElementFromList() {
        Assertions.assertEquals(integerTestList.removeLast(), 70);
        Assertions.assertEquals(integerTestList.removeLast(), 40);
        Assertions.assertEquals(integerTestList.removeLast(), 50);

        Assertions.assertEquals(integerTestList.size(), 3);
    }


    @Test
    void removeLast_ShouldThrowsException_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertThrows(NoSuchElementException.class, emptyList::removeLast);
    }

    @Test
    void pollFirst_ShouldRetrievesAndRemovesTheFirstElementOfList_whenListIsNotEmpty() {
        Assertions.assertEquals(integerTestList.pollFirst(), 10);
        Assertions.assertEquals(integerTestList.pollFirst(), 40);
        Assertions.assertEquals(integerTestList.pollFirst(), 30);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void pollFirst_ShouldReturnNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.pollFirst());
    }

    @Test
    void pollLast_ShouldRetrievesAndRemovesTheLastElementOfList_whenListIsNotEmpty() {
        Assertions.assertEquals(integerTestList.pollLast(), 70);
        Assertions.assertEquals(integerTestList.pollLast(), 40);
        Assertions.assertEquals(integerTestList.pollLast(), 50);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void pollLast_ShouldReturnNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.pollLast());
    }

    @Test
    void getFirst_ShouldReturnsTheFirstElementOfList() {
        Assertions.assertEquals(integerTestList.getFirst(), 10);
        integerTestList.removeFirst();
        Assertions.assertEquals(integerTestList.getFirst(), 40);
    }

    @Test
    void getLast_ReturnsTheLastElementOfList() {
        Assertions.assertEquals(integerTestList.getLast(), 70);
        integerTestList.removeLast();
        Assertions.assertEquals(integerTestList.getLast(), 40);
    }

    @Test
    void peekFirst_ShouldRetrievesTheFirstElementOfList_thenListIsNotEmpty() {
        Assertions.assertEquals(integerTestList.peekFirst(), 10);
        integerTestList.removeFirst();
        Assertions.assertEquals(integerTestList.getFirst(), 40);
    }

    @Test
    void peekFirst_ShouldReturnsNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.peekFirst());

    }

    @Test
    void peekLast_ShouldRetrievesTheLastElementOfList() {
        Assertions.assertEquals(integerTestList.peekLast(), 70);
        integerTestList.removeLast();
        Assertions.assertEquals(integerTestList.peekLast(), 40);
    }

    @Test
    void peekLast_ShouldReturnsNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.peekLast());
    }

    @Test
    void removeFirstOccurrence_ShouldRemovesTheFirstOccurrenceOfTheElementInList () {
        Assertions.assertTrue(integerTestList.removeFirstOccurrence(30));
        Assertions.assertFalse(integerTestList.removeFirstOccurrence(100000));
    }

    @Test
    void removeLastOccurrenceShouldRemovesTheLastOccurrenceOfTheElementInList() {
        Assertions.assertTrue(integerTestList.removeFirstOccurrence(40));
        Assertions.assertFalse(integerTestList.removeFirstOccurrence(100000));
    }

    @Test
    void offer_ShouldAddsElementAsTheTailOfList() {
        integerTestList.offer(15);
        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 15);

        integerTestList.offer(22);
        Assertions.assertEquals(integerTestList.get(integerTestList.size() - 1), 22);
    }

    @Test
    void remove_ShouldRetrievesAndRemovesTheFirstElementOfList() {
        Assertions.assertEquals(integerTestList.remove(), 10);
        Assertions.assertEquals(integerTestList.remove(), 40);
        Assertions.assertEquals(integerTestList.remove(), 30);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void remove_ShouldThrowsException_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertThrows(NoSuchElementException.class, emptyList::remove);
    }

    @Test
    void poll_ShouldRemovesAndReturnsFirstElementFromList() {
        Assertions.assertEquals(integerTestList.poll(), 10);
        Assertions.assertEquals(integerTestList.poll(), 40);
        Assertions.assertEquals(integerTestList.poll(), 30);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void poll_ShouldReturnNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.poll());
    }

    @Test
    void element_ShouldReturnsTheFirstElementOfList() {
        Assertions.assertEquals(integerTestList.element(), 10);
        integerTestList.removeFirst();
        Assertions.assertEquals(integerTestList.element(), 40);
    }

    @Test
    void peek_ShouldRetrievesTheFirstElementOfList_thenListIsNotEmpty() {
        Assertions.assertEquals(integerTestList.peek(), 10);
        integerTestList.removeFirst();
        Assertions.assertEquals(integerTestList.peek(), 40);
    }

    @Test
    void peek_ShouldReturnsNull_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertNull(emptyList.peek());

    }

    @Test
    void push_ShouldInsertElementAtBeginningOfThisList() {
        integerTestList.addFirst(15);
        Assertions.assertEquals(integerTestList.get(0), 15);

        integerTestList.addFirst(22);
        integerTestList.addFirst(35);

        Assertions.assertEquals(integerTestList.get(1), 22);
        Assertions.assertEquals(integerTestList.get(2), 15);
    }

    @Test
    void pop_ShouldRemovesAndReturnsFirstElementFromList() {
        Assertions.assertEquals(integerTestList.removeFirst(), 10);
        Assertions.assertEquals(integerTestList.removeFirst(), 40);
        Assertions.assertEquals(integerTestList.removeFirst(), 30);

        Assertions.assertEquals(integerTestList.size(), 3);
    }

    @Test
    void pop_ShouldThrowsException_whenListIsEmpty() {
        LinkedListImpl<Integer> emptyList = new LinkedListImpl<>();
        Assertions.assertThrows(NoSuchElementException.class, emptyList::pop);
    }

    @Test
    void size_ShouldReturnCorrectSizeOfList() {
        LinkedListImpl<Integer> integerTestList = new LinkedListImpl<>();

        Assertions.assertEquals(integerTestList.size(), 0);

        final int numberToAdd = 1000;
        for (int i = 0; i < 1000; i++) {
            integerTestList.add(i);
        }

        Assertions.assertEquals(integerTestList.size(), numberToAdd);
    }

    @Test
    void isEmpty_ShouldReturnTrue_whenListIsEmpty_otherwiseFalse() {
        LinkedListImpl<Integer> integerTestList = new LinkedListImpl<>();
        Assertions.assertTrue(integerTestList.isEmpty());
        integerTestList.add(10);
        Assertions.assertFalse(integerTestList.isEmpty());
    }

    @Test
    void contains_ShouldReturnTrue_whenListContainsElement_otherwiseFalse() {
        LinkedListImpl<Integer> integerTestList = new LinkedListImpl<>();
        integerTestList.add(10);
        integerTestList.add(20);
        integerTestList.add(30);

        Assertions.assertTrue(integerTestList.contains(20));
        Assertions.assertTrue(integerTestList.contains(30));
        Assertions.assertTrue(integerTestList.contains(10));
        Assertions.assertFalse(integerTestList.contains(100));
        Assertions.assertFalse(integerTestList.contains(null));
    }


    @Test
    void addShouldAddElements_whenInputParameterIsCorrectObject() {
        LinkedListImpl<Integer> testList = new LinkedListImpl<>();
        final int numberToAdd = 100;
        Integer[] actualArray = new Integer[numberToAdd];
        for (int i = 0; i < numberToAdd; i++) {
            actualArray[i] = i;
            testList.add(i);
        }

        Assertions.assertEquals(testList.size(), numberToAdd);
        for (int i = 0; i < actualArray.length; i++) {
            Assertions.assertEquals(testList.get(i), actualArray[i]);
        }
    }

    @Test
    void addShouldAddNull_whenInputParameterIsNull() {
        LinkedListImpl<Integer> integerTestList = new LinkedListImpl<>();
        final int numberToAdd = 10;
        for (int i = 0; i < numberToAdd; i++) {
            integerTestList.add(null);
        }

        Assertions.assertEquals(integerTestList.size(), numberToAdd);
        for (int i = 0; i < integerTestList.size(); i++) {
            Assertions.assertEquals(integerTestList.get(i), null);
        }
    }

    @Test
    void removeShouldRemoveByObjectAndByIndex() {
        integerTestList.remove(2);
        Assertions.assertEquals(integerTestList.size(), 5);

        integerTestList.remove(Integer.valueOf(50));
        Assertions.assertEquals(integerTestList.size(), 4);
    }

    @Test
    void removeShouldThrowsException_whenIndexIsInvalid() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.remove(10000));
    }

    @Test
    void containsAll_ShouldReturnTrue_whenInputCollectionIsContained() {
        List<Integer> collection = List.of(10, 30, 70);
        Assertions.assertTrue(integerTestList.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotContained() {
        List<Integer> collection = List.of(5, 15, 25);
        Assertions.assertFalse(integerTestList.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotPartiallyContained() {
        List<Integer> collection = List.of(20, 30, 100);
        Assertions.assertFalse(integerTestList.containsAll(collection));
    }

    @Test
    void clear_shouldClearAllLinkedList() {
        integerTestList.clear();
        Assertions.assertEquals(integerTestList.size(), 0);
    }

    @Test
    void get_ShouldReturnElementLocatedAtIndex_whenParameterIsValidIndex() {
        Assertions.assertEquals(integerTestList.get(0), 10);
        Assertions.assertEquals(integerTestList.get(1), 40);
        Assertions.assertEquals(integerTestList.get(2), 30);
    }

    @Test
    void get_ShouldThrowsException_whenParameterIsInvalidIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.get(10000));
    }


    @Test
    void set_ShouldSetElementLocatedAtIndex_whenParameterIsIndex() {
        integerTestList.set(1, 500);
        Assertions.assertEquals(integerTestList.get(1), 500);
    }

    @Test
    void set_ShouldThrowsException_whenParameterIsInvalidIndexAndObject() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.set(-1, 2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerTestList.set(1000, 2));
    }

    @Test
    void indexOf_ShouldReturnCorrectIndex_whenListContainsElement() {
        Assertions.assertEquals(integerTestList.indexOf(50), 3);
    }

    @Test
    void indexOf_ShouldReturnMinusOne_whenListDoesNotContainsElement() {
         Assertions.assertEquals(integerTestList.indexOf(78517), -1);
    }

    @Test
    void lastIndexOf_ShouldReturnCorrectIndex_whenListContainsElement() {
        Assertions.assertEquals(integerTestList.lastIndexOf(30), 2);
    }

    @Test
    void lastIndexOf_ShouldReturnMinusOne_whenListDoesNotContainsElement() {
        Assertions.assertEquals(integerTestList.indexOf(67654567), -1);
    }

    @Test
    void toArray_ShouldReturnCorrectArrayOfElements_whenNoInputParameters() {
        Object[] expectedArray = integerTestList.toArray();

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
        Integer[] array = new Integer[integerTestList.size()];
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.toArray(array));
    }

    @Test
    void listIterator_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.listIterator());
    }

    @Test
    void listIterator_ShouldThrowsUnsupportedOperationException_whenIndexIsAny() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.listIterator(10));
    }

    @Test
    void subList_ShouldThrowsException_withAnyParameters() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.subList(0, 0));
    }

    @Test
    void subList_ShouldThrowsException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.descendingIterator());
    }

    @Test
    void retainAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionOrNull() {
        Collection<Integer> collection = Collections.singletonList(500);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.retainAll(collection));
    }

    @Test
    void addAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollection() {
        List<Integer> testIntegerCollection = List.of(1, 2);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> integerTestList.addAll(testIntegerCollection));
    }

    @Test
    void iterator_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.iterator());
    }

    @Test
    void toArray_ShouldThrowsUnsupportedOperationException_whenInputIsArray() {
        Integer[] testIntegerCollection = {10, 40};
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.toArray(testIntegerCollection));
    }

    @Test
    void addAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionWithIndex() {
        List<Integer> testIntegerCollection = List.of(10, 40);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> integerTestList.addAll(2, testIntegerCollection));
    }

    @Test
    void removeAll_ShouldThrowsUnsupportedOperationException_whenInputIsListOrNull() {
        List<Integer> testIntegerCollection = List.of(10, 40);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> integerTestList.removeAll(testIntegerCollection));
    }
}
