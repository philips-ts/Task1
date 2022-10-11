package com.tarasenko.shop.bucket;

import com.tarasenko.shop.model.Food;
import com.tarasenko.shop.model.NotFood;
import com.tarasenko.shop.model.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;


class BucketImplTest {
    BucketImpl bucket;

    @TempDir
    static Path tempDir;
    static Path tempFile;

    @BeforeAll
    static void setUp() throws IOException {
        tempFile = Files.createFile(tempDir.resolve("bucket_test"));
    }

    @BeforeEach
    void setUpEach() {
        bucket = new BucketImpl();

        Food food = new Food();
        food.setName("Apple");
        food.setPrice(50);
        food.setMaxStorageTemperature((short)25);
        food.setDateOfManufacture(LocalDate.of(2023,3,9));
        bucket.addProduct(food, 1);

        Food food2 = new Food();
        food2.setName("Cookie");
        food2.setPrice(80);
        food2.setMaxStorageTemperature((short)30);
        food2.setDateOfManufacture(LocalDate.of(2023,2,20));
        bucket.addProduct(food2, 2);

        NotFood notFood = new NotFood();
        notFood.setName("Pencil");
        notFood.setPrice(80);
        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
        notFood.setBreakable(false);
        bucket.addProduct(notFood, 3);
    }


    @Test
    void addProduct_ShouldThrowsException_whenProductIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(null, 1));
    }

    @Test
    void addProduct_ShouldThrowsException_whenQuantityIsBelowOne() {
        final NotFood notFood = new NotFood();
        notFood.setName("Test");
        notFood.setPrice(111);
        notFood.setDateOfManufacture(LocalDate.of(2020,1,2));

        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(notFood, 0));
        Assertions.assertThrows(RuntimeException.class, () -> bucket.addProduct(notFood, -10));
    }

    @Test
    void addProduct_ShouldAddProductToBucket_whenParametersAreValid() {
        final NotFood notFood = new NotFood();
        notFood.setName("Test");
        notFood.setPrice(111);
        notFood.setDateOfManufacture(LocalDate.of(2020,1,2));
        bucket.addProduct(notFood, 20);

        Assertions.assertEquals(bucket.getOrderItems().size(), 4);
    }


    @Test
    void removeProduct_ShouldReturnTrue_whenProductIdIsCorrect() {
        Assertions.assertTrue(bucket.removeProductByName("Cookie"));
        Assertions.assertTrue(bucket.removeProductByName("Pencil"));
    }
    @Test
    void removeProduct_ShouldReturnFalse_whenProductIdIsIncorrect() {
        Assertions.assertThrows(Exception.class, () -> bucket.removeProductByName(null));
    }


    @Test
    void getBucket_ShouldReturnOrderItemList() {
        List<OrderItem> orderItems =  bucket.getOrderItems();
        Assertions.assertEquals(orderItems.size(), 3);
    }

    @Test
    void save_shouldSaveDataToFile() throws IOException {
        Assertions.assertTrue(bucket.save(tempFile.toString()));

        boolean isExists = Files.exists(tempFile.toAbsolutePath());
        Assertions.assertTrue(isExists);

        long expectedFileSize = Files.size(tempFile.toAbsolutePath());
        Assertions.assertNotEquals(expectedFileSize, 0);
    }
}