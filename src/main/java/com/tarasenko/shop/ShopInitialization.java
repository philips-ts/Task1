package com.tarasenko.shop;

import com.tarasenko.shop.entity.Food;
import com.tarasenko.shop.entity.NotFood;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShopInitialization {

    public List<Food> getTestFoodData() {
        List<Food> foodList = new ArrayList<>();

        Food food = new Food();
        food.setName("Apple");
        food.setPrice(50);
        food.setMaxStorageTemperature((short)25);
        food.setDateOfManufacture(LocalDate.of(2023,3,9));
        food.setShelfLifeMonths(6);
        foodList.add(food);

        Food food2 = new Food();
        food2.setName("Cookie");
        food2.setPrice(80);
        food2.setMaxStorageTemperature((short)30);
        food2.setDateOfManufacture(LocalDate.of(2023,2,20));
        food2.setShelfLifeMonths(12);
        foodList.add(food2);

        Food food3 = new Food();
        food3.setName("Milk");
        food3.setPrice(30);
        food3.setMaxStorageTemperature((short)5);
        food3.setDateOfManufacture(LocalDate.of(2023,2,20));
        food3.setShelfLifeMonths(2);
        foodList.add(food3);

        Food food4 = new Food();
        food4.setName("Tea");
        food4.setPrice(200);
        food4.setMaxStorageTemperature((short)30);
        food4.setDateOfManufacture(LocalDate.of(2024,2,2));
        food4.setShelfLifeMonths(24);
        foodList.add(food4);

        Food food5 = new Food();
        food5.setName("Bread");
        food5.setPrice(35);
        food5.setMaxStorageTemperature((short)25);
        food5.setDateOfManufacture(LocalDate.of(2023,1,4));
        food.setShelfLifeMonths(1);
        foodList.add(food5);

        return foodList;
    }

    public List<NotFood> getTestNotFoodData() {
        List<NotFood> notFoodList = new ArrayList<>();

        NotFood notFood = new NotFood();
        notFood.setName("Pencil");
        notFood.setPrice(80);
        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
        notFood.setBreakable(false);
        notFoodList.add(notFood);

        NotFood notFood2 = new NotFood();
        notFood2.setName("Laptop");
        notFood2.setPrice(2180);
        notFood2.setDateOfManufacture(LocalDate.of(2020,1,5));
        notFood2.setBreakable(true);
        notFoodList.add(notFood2);

        NotFood notFood3 = new NotFood();
        notFood3.setName("Mobile phone");
        notFood3.setPrice(1530);
        notFood3.setDateOfManufacture(LocalDate.of(2020,7,5));
        notFood3.setBreakable(true);
        notFoodList.add(notFood3);

        NotFood notFood4 = new NotFood();
        notFood4.setName("Razor");
        notFood4.setPrice(280);
        notFood4.setDateOfManufacture(LocalDate.of(2021,1,30));
        notFood4.setBreakable(false);
        notFoodList.add(notFood4);

        return notFoodList;
    }
}
