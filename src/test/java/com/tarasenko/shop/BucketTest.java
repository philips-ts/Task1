package com.tarasenko.shop;

import com.tarasenko.shop.model.Food;
import com.tarasenko.shop.model.NotFood;
import com.tarasenko.shop.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;


class BucketTest {
    Bucket bucket;

    @BeforeEach
    void setUp() {
        bucket = new Bucket();
        int id = 1;

        Food food = new Food();
        food.setId(id++);
        food.setName("Apple");
        food.setPrice(50);
        food.setMaxStorageTemperature((short)25);
        food.setExpirationDate(LocalDate.of(2023,3,9));
        bucket.addProduct(food, 5);

        Food food2 = new Food();
        food2.setId(id++);
        food2.setName("Cookie");
        food2.setPrice(80);
        food2.setMaxStorageTemperature((short)30);
        food2.setExpirationDate(LocalDate.of(2023,2,20));
        bucket.addProduct(food2, 1);

        NotFood notFood = new NotFood();
        notFood.setId(id++);
        notFood.setName("Pencil");
        notFood.setPrice(80);
        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
        bucket.addProduct(notFood, 2);
    }


    @Test
    void addProduct_ShouldThrowsException_whenProductIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(null, 1));
    }

    @Test
    void addProduct_ShouldThrowsException_whenQuantityIsBelowOne() {
        final NotFood notFood = new NotFood();
        notFood.setId(20);
        notFood.setName("Test");
        notFood.setPrice(111);
        notFood.setDateOfManufacture(LocalDate.of(2020,1,2));

        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(notFood, 0));
        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(notFood, -10));
    }

    @Test
    void addProduct_ShouldAddProductToBucket_whenParametersAreValid() {
        final NotFood notFood = new NotFood();
        notFood.setId(20);
        notFood.setName("Test");
        notFood.setPrice(111);
        notFood.setDateOfManufacture(LocalDate.of(2020,1,2));
        bucket.addProduct(notFood, 20);

        Assertions.assertEquals(bucket.getNumberOfProducts(), 4);
    }


    @Test
    void removeProduct_ShouldReturnTrue_whenProductIdIsCorrect() {
        Assertions.assertTrue(bucket.removeProduct(1));
        Assertions.assertTrue(bucket.removeProduct(3));
    }
    @Test
    void removeProduct_ShouldReturnFalse_whenProductIdIsIncorrect() {
        Assertions.assertFalse(bucket.removeProduct(100));
        Assertions.assertFalse(bucket.removeProduct(-10));
    }


    @Test
    void getBucket_ShouldReturnMapWithProductsAndQuantities() {
        Map<Product, Integer> bucketMap =  bucket.getBucket();
        Assertions.assertEquals(bucketMap.size(), 3);
    }

    @Test
    void clear_shouldClearBucket() {
        bucket.clear();
        Assertions.assertEquals(bucket.getNumberOfProducts(), 0);
    }
}