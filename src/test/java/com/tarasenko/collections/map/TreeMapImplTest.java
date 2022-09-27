package com.tarasenko.collections.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TreeMapImplTest {
    TreeMapImpl<Integer, String> testTreeMap;


    @BeforeEach
    void setUp(){
        testTreeMap = new TreeMapImpl<>();

        testTreeMap.put(5, "Test5");
        testTreeMap.put(4, "Test4");
        testTreeMap.put(7, "Test7");
        testTreeMap.put(8, null);
        testTreeMap.put(1, "Test1");
        testTreeMap.put(2, "Test2");
    }

    @Test
    void size() {
        Assertions.assertEquals(testTreeMap.size(), 6);
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(testTreeMap.isEmpty());

        TreeMapImpl<Integer, String> emptyTreeMap = new TreeMapImpl<>();
        Assertions.assertTrue(emptyTreeMap.isEmpty());
    }

    @Test
    void clear() {
        testTreeMap.clear();
        Assertions.assertEquals(testTreeMap.size(), 0);
    }

    @Test
    void containsKey_ShouldReturnTrue_whenMapContainsKey_otherwiseFalse() {
        Assertions.assertTrue(testTreeMap.containsKey(7));
        Assertions.assertTrue(testTreeMap.containsKey(2));
        Assertions.assertTrue(testTreeMap.containsKey(5));
        Assertions.assertFalse(testTreeMap.containsKey(100));
    }

    @Test
    void containsKey_ShouldThrowException_whenKeyIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> testTreeMap.containsKey(null));
    }

    @Test
    void containsValue_ShouldReturnTrue_whenMapContainsValue_otherwiseFalse() {
        Assertions.assertTrue(testTreeMap.containsValue("Test5"));
        Assertions.assertTrue(testTreeMap.containsValue("Test1"));
        Assertions.assertTrue(testTreeMap.containsValue(null));
        Assertions.assertFalse(testTreeMap.containsValue("AAAAAAAAAAAA"));
    }

    @Test
    void get_ShouldReturnsValueToWhichTheKeyIsMapped() {
        Assertions.assertEquals(testTreeMap.get(5), "Test5");
        Assertions.assertNull(testTreeMap.get(8));
    }

    @Test
    void get_ShouldShouldThrowException_whenKeyIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> testTreeMap.get(null));
    }

    @Test
    void get_ShouldReturnsNull_whenMapContainsNoMappingForKey() {
        Assertions.assertNull(testTreeMap.get(1000));
        Assertions.assertNull(testTreeMap.get(-1));
    }

    @Test
    void put_ShouldInsertKeyAndValue() {
        Assertions.assertEquals(testTreeMap.size(), 6);
    }

    @Test
    void put_ShouldShouldThrowException_whenKeyIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> testTreeMap.put(null, "111"));
    }

    @Test
    void remove_ShouldRemoveKeyAndValueFromMap() {
        testTreeMap.remove(5);
        testTreeMap.remove(8);
    }

    @Test
    void remove_ShouldShouldThrowException_whenKeyIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> testTreeMap.remove(null));
    }

    @Test
    void keySet_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeMap.keySet());
    }

    @Test
    void values_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeMap.values());
    }

    @Test
    void entrySet_ShouldThrowsUnsupportedOperationException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeMap.entrySet());
    }

    @Test
    void putAll_ShouldThrowsUnsupportedOperationException_whenParameterIsAny() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> testTreeMap.putAll(null));
    }
}