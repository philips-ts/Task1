package com.tarasenko.shop;

import com.tarasenko.shop.Warehouse.Warehouse;
import com.tarasenko.shop.Warehouse.WarehouseImpl;
import com.tarasenko.shop.bucket.Bucket;
import com.tarasenko.shop.bucket.BucketImpl;
import com.tarasenko.shop.currency.Currency;
import com.tarasenko.shop.currency.PLNCurrency;
import com.tarasenko.shop.currency.UAHCurrency;
import com.tarasenko.shop.model.Food;
import com.tarasenko.shop.model.NotFood;

import java.time.LocalDate;
import java.util.List;

public class App {
    private static Warehouse getSimpleWarehouse() {
        Warehouse warehouse = new WarehouseImpl();

        Food food = new Food();
        food.setName("Apple");
        food.setPrice(50);
        food.setMaxStorageTemperature((short)25);
        food.setDateOfManufacture(LocalDate.of(2023,3,9));
        warehouse.addProduct(food);

        Food food2 = new Food();
        food2.setName("Cookie");
        food2.setPrice(80);
        food2.setMaxStorageTemperature((short)30);
        food2.setDateOfManufacture(LocalDate.of(2023,2,20));
        warehouse.addProduct(food2);

        Food food3 = new Food();
        food3.setName("Milk");
        food3.setPrice(30);
        food3.setMaxStorageTemperature((short)5);
        food3.setDateOfManufacture(LocalDate.of(2023,2,20));
        warehouse.addProduct(food3);

        Food food4 = new Food();
        food4.setName("Tea");
        food4.setPrice(200);
        food4.setMaxStorageTemperature((short)30);
        food4.setDateOfManufacture(LocalDate.of(2024,2,2));
        warehouse.addProduct(food4);

        Food food5 = new Food();
        food5.setName("Bread");
        food5.setPrice(35);
        food5.setMaxStorageTemperature((short)25);
        food5.setDateOfManufacture(LocalDate.of(2023,1,4));
        warehouse.addProduct(food5);


        NotFood notFood = new NotFood();
        notFood.setName("Pencil");
        notFood.setPrice(80);
        notFood.setDateOfManufacture(LocalDate.of(2020,12,2));
        notFood.setBreakable(false);
        warehouse.addProduct(notFood);

        NotFood notFood2 = new NotFood();
        notFood2.setName("Laptop");
        notFood2.setPrice(2180);
        notFood2.setDateOfManufacture(LocalDate.of(2020,1,5));
        notFood.setBreakable(true);
        warehouse.addProduct(notFood2);

        NotFood notFood3 = new NotFood();
        notFood3.setName("Mobile phone");
        notFood3.setPrice(1530);
        notFood3.setDateOfManufacture(LocalDate.of(2020,7,5));
        notFood.setBreakable(true);
        warehouse.addProduct(notFood3);

        NotFood notFood4 = new NotFood();
        notFood4.setName("Razor");
        notFood4.setPrice(280);
        notFood4.setDateOfManufacture(LocalDate.of(2021,1,30));
        notFood.setBreakable(false);
        warehouse.addProduct(notFood4);

        return warehouse;
    }

    private static List<Currency> getCurrencies() {
        final List<Currency> currencies = List.of(
                new UAHCurrency("UAH", "Ukrainian Hryvni", 40),
                new PLNCurrency("PLN", "Polish zloty", 5)
        );

        return currencies;
    }

    public static void main(String[] args) {
        Warehouse warehouse = getSimpleWarehouse();
        Bucket bucket = new BucketImpl();
        Menu menu = new Menu(bucket, warehouse, getCurrencies());
        menu.showMenu();
    }
}
