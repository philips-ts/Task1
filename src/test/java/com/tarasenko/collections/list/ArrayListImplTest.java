package com.tarasenko.collections.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;



class ArrayListImplTest {

    static ArrayListImpl<String> exceptionTestList;

    @BeforeAll
    static void setUp(){
        exceptionTestList = new ArrayListImpl<>();
        exceptionTestList.add("test1");
        exceptionTestList.add("test2");
        exceptionTestList.add("test3");
    }

    @Test
    void addShouldAddElements_whenInputParameterIsCorrectObject() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        final int numberToAdd = 100;
        Integer[] actualArray = new Integer[numberToAdd];
        for (int i = 0; i < numberToAdd; i++) {
            actualArray[i] = i;
            integerTestList.add(i);
        }

        Assertions.assertEquals(integerTestList.size(), numberToAdd);
        for (int i = 0; i < actualArray.length; i++) {
            Assertions.assertEquals(integerTestList.get(i), actualArray[i]);
        }
    }

    @Test
    void addShouldAddNull_whenInputParameterIsNull() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
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
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("test1");
        stringTestList.add("test2");
        stringTestList.add("test3");
        stringTestList.add("test4");

        stringTestList.remove(2);
        Assertions.assertEquals(stringTestList.size(), 3);

        stringTestList.remove("test1");
        Assertions.assertEquals(stringTestList.size(), 2);
    }

    @Test
    void removeShouldThrowsException_whenIndexIsInvalid() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.remove(100000));
    }

    @Test
    void clear_shouldClearAllArrayList() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(1);
        integerTestList.add(2);
        integerTestList.add(3);

        Assertions.assertEquals(integerTestList.size(), 3);
        integerTestList.clear();
        Assertions.assertEquals(integerTestList.size(), 0);
    }

    @Test
    void get_ShouldReturnElementLocatedAtIndex_whenParameterIsValidIndex() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(1);
        integerTestList.add(2);
        integerTestList.add(3);

        Assertions.assertEquals(integerTestList.get(0), 1);
        Assertions.assertEquals(integerTestList.get(1), 2);
        Assertions.assertEquals(integerTestList.get(2), 3);
    }

    @Test
    void get_ShouldThrowsException_whenParameterIsInvalidIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.get(10000));
    }
    

    @Test
    void set_ShouldSetElementLocatedAtIndex_whenParameterIsIndex() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("a");
        stringTestList.add("b");
        stringTestList.add("c");

        stringTestList.set(1, "d");
        Assertions.assertEquals(stringTestList.get(1), "d");
    }

    @Test
    void set_ShouldThrowsException_whenParameterIsInvalidIndexAndObject() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.set(-1, "ff"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> exceptionTestList.set(100000, "bb"));
    }

    @Test
    void size_ShouldReturnSizeOfList() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();

        Assertions.assertEquals(integerTestList.size(), 0);

        final int numberToAdd = 1000;
        for (int i = 0; i < 1000; i++) {
            integerTestList.add(i);
        }

        Assertions.assertEquals(integerTestList.size(), numberToAdd);
    }

    @Test
    void isEmpty_ShouldReturnFalse_whenListIsEmpty_OtherwiseTrue() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        Assertions.assertTrue(integerTestList.isEmpty());
        integerTestList.add(10);
        Assertions.assertFalse(integerTestList.isEmpty());
    }

    @Test
    void contains_ShouldReturnTrue_whenListContainsElement_OtherwiseFalse() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
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
    void containsAll_ShouldReturnTrue_whenInputCollectionIsContained() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(10);
        integerTestList.add(20);
        integerTestList.add(30);
        integerTestList.add(40);
        integerTestList.add(50);
        List<Integer> collection = List.of(20, 30, 40);

        Assertions.assertTrue(integerTestList.containsAll(collection));
    }
    
    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotContained() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(10);
        integerTestList.add(20);
        integerTestList.add(30);
        integerTestList.add(40);
        integerTestList.add(50);
        List<Integer> collection = List.of(5, 15, 25);

        Assertions.assertFalse(integerTestList.containsAll(collection));
    }

    @Test
    void containsAll_ShouldReturnFalse_whenInputCollectionIsNotPartiallyContained() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(10);
        integerTestList.add(20);
        integerTestList.add(30);
        integerTestList.add(40);
        integerTestList.add(50);
        List<Integer> collection = List.of(20, 30, 100);

        Assertions.assertFalse(integerTestList.containsAll(collection));
    }

    @Test
    void indexOf_ShouldReturnCorrectIndex_whenListContainsElement() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("aa");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("fff");

        Assertions.assertEquals(stringTestList.indexOf("ccc"), 2);
    }

    @Test
    void indexOf_ShouldReturnMinusOne_whenListDoesNotContainsElement() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("aa");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("fff");

        Assertions.assertEquals(stringTestList.indexOf("xxx"), -1);
    }


    @Test
    void lastIndexOf_ShouldReturnCorrectIndex_whenListContainsElement() {
        ArrayListImpl<Integer> integerTestList = new ArrayListImpl<>();
        integerTestList.add(5);
        integerTestList.add(50);
        integerTestList.add(20);
        integerTestList.add(50);
        integerTestList.add(70);

        Assertions.assertEquals(integerTestList.lastIndexOf(50), 3);
    }

    @Test
    void lastIndexOf_ShouldReturnMinusOne_whenListDoesNotContainsElement() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("aa");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("fff");

        Assertions.assertEquals(stringTestList.indexOf("xxx"), -1);
    }

    @Test
    void addAll_ShouldInsertCollection_whenInputIsOnlyCollection() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("aa");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("fff");
        List<String> testCollectionToInsert = List.of("1", "2", "3", "4");

        stringTestList.addAll(testCollectionToInsert);

        Assertions.assertEquals(stringTestList.size(), 9);
        Assertions.assertTrue(stringTestList.contains("1"));
        Assertions.assertTrue(stringTestList.contains("2"));
        Assertions.assertTrue(stringTestList.contains("3"));
        Assertions.assertTrue(stringTestList.contains("4"));
    }


    @Test
    void toArray_ShouldReturnCorrectArrayOfElements_whenNoInputParameters() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("a");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("eeeee");

        Object[] expectedArray = stringTestList.toArray();

        Assertions.assertEquals(expectedArray.length, 5);
        Assertions.assertEquals(expectedArray[0], "a");
        Assertions.assertEquals(expectedArray[1], "bb");
        Assertions.assertEquals(expectedArray[2], "ccc");
        Assertions.assertEquals(expectedArray[3], "d");
        Assertions.assertEquals(expectedArray[4], "eeeee");
    }

    @Test
    void toArray_ShouldReturnCorrectArrayOfElements_whenInputIsArrayOrNull() {
        List<String> stringTestList = new ArrayListImpl<>();
        stringTestList.add("a");
        stringTestList.add("bb");
        stringTestList.add("ccc");
        stringTestList.add("d");
        stringTestList.add("eeeee");

        String[] expectedArray = new String[stringTestList.size()];
        expectedArray = stringTestList.toArray(expectedArray);

        Assertions.assertEquals(expectedArray.length, 5);
        Assertions.assertEquals(expectedArray[0], "a");
        Assertions.assertEquals(expectedArray[1], "bb");
        Assertions.assertEquals(expectedArray[2], "ccc");
        Assertions.assertEquals(expectedArray[3], "d");
        Assertions.assertEquals(expectedArray[4], "eeeee");
    }

    @Test
    void addAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionWithIndex() {
        List<String> testStringList = List.of("1", "2");
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> exceptionTestList.addAll(5, testStringList));
    }

    @Test
    void removeAll_ShouldThrowsUnsupportedOperationException_whenInputIsListOrNull() {
        List<String> testStringList = List.of("1", "2");
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.removeAll(testStringList));
    }

    @Test
    void retainAll_ShouldThrowsUnsupportedOperationException_whenInputIsCollectionOrNull() {
        Collection<String> collection = Collections.singletonList("test");
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.retainAll(collection));
    }

    @Test
    void iterator_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.iterator());
    }

    @Test
    void listIterator_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.listIterator());
    }

    @Test
    void listIterator_ShouldThrowsUnsupportedOperationException_whenIndexIsAny() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.listIterator(10));
    }

    @Test
    void subList_ShouldThrowsException_withAnyParameters() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> exceptionTestList.subList(0, 0));
    }
}
