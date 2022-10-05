package com.tarasenko.shop;


import com.tarasenko.shop.model.Food;
import com.tarasenko.shop.model.NotFood;
import com.tarasenko.shop.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Product> getMenu() {
        List<Product> productList = new ArrayList<>();
        int id = 1;


        Food food = new Food();
        food.setId(id++);
        food.setName("Apple");
        food.setPrice(50);
        food.setMaxStorageTemperature((short)25);
        food.setExpirationDate(LocalDate.of(2023,3,9));
        productList.add(food);

        Food food2 = new Food();
        food2.setId(id++);
        food2.setName("Cookie");
        food2.setPrice(80);
        food2.setMaxStorageTemperature((short)30);
        food2.setExpirationDate(LocalDate.of(2023,2,20));
        productList.add(food2);

        Food food3 = new Food();
        food3.setId(id++);
        food3.setName("Milk");
        food3.setPrice(30);
        food3.setMaxStorageTemperature((short)5);
        food3.setExpirationDate(LocalDate.of(2023,2,20));
        productList.add(food3);

        Food food4 = new Food();
        food4.setId(id++);
        food4.setName("Tea");
        food4.setPrice(200);
        food4.setMaxStorageTemperature((short)30);
        food4.setExpirationDate(LocalDate.of(2024,2,2));
        productList.add(food4);

        Food food5 = new Food();
        food5.setId(id++);
        food5.setName("Bread");
        food5.setPrice(35);
        food5.setMaxStorageTemperature((short)25);
        food5.setExpirationDate(LocalDate.of(2023,1,4));
        productList.add(food5);


        NotFood notFood = new NotFood();
        notFood.setId(id++);
        notFood.setName("Pencil");
        notFood.setPrice(80);
        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
        productList.add(notFood);

        NotFood notFood2 = new NotFood();
        notFood2.setId(id++);
        notFood2.setName("Laptop");
        notFood2.setPrice(2180);
        notFood2.setDateOfManufacture(LocalDate.of(2020,1,5));
        productList.add(notFood2);

        NotFood notFood3 = new NotFood();
        notFood3.setId(id++);
        notFood3.setName("Mobile phone");
        notFood3.setPrice(1530);
        notFood3.setDateOfManufacture(LocalDate.of(2020,7,5));
        productList.add(notFood3);

        NotFood notFood4 = new NotFood();
        notFood4.setId(id++);
        notFood4.setName("Razor");
        notFood4.setPrice(280);
        notFood4.setDateOfManufacture(LocalDate.of(2021,1,30));
        productList.add(notFood4);


        return productList;
    }


    public static void main(String[] args) {
        List<Product> productList = getMenu();
        Menu menu = new Menu(productList);
        menu.showMenu();
    }
}
