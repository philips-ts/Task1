package com.tarasenko.shop;

import com.tarasenko.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Bucket bucket = new Bucket();
    private final List<Product> productList;

    private Scanner scanner;

    public Menu(List<Product> productList) {
        System.out.println();
        this.productList = new ArrayList<>(productList);
    }

    private void showAllProducts() {
        productList.forEach(System.out::println);
    }

    private void addProductToBucket() {
        System.out.println("Enter a product ID to add to the bucket: ");
        int productId = Integer.parseInt(scanner.nextLine());

        for (Product product : productList) {
            if (productId == product.getId()) {
                bucket.addProduct(product, 1);
                break;
            }
        }
    }

    private void showBucket() {
        System.out.println("Bucket: ");
        for (Map.Entry<Product, Integer> bucketItem : bucket.getBucket().entrySet()) {
            System.out.println("Product: " + bucketItem.getKey() + "\nQuantity: " + bucketItem.getValue());
        }
    }

    private void deleteFromBucket() {
        System.out.println("Enter a product ID to add from the bucket: ");
        int productId = Integer.parseInt(scanner.nextLine());

        boolean isDeleted = bucket.removeProduct(productId);
        if (isDeleted) {
            System.out.println("The product removed successfully");
        } else {
            System.out.println("The product was not found in the bucket");
        }
    }

    private void clearBucket() {
        bucket.clear();
    }

    private void printMenu() {
        System.out.println("""
                                ---------------------------------------------------
                                Select action:
                                1. Show product list
                                2. Add product to the bucket
                                3. Show products in the bucket
                                4. Delete product from the bucket
                                5. Clear the bucket
                                6. Exit
                                ---------------------------------------------------
                                """);
    }


    public void showMenu() {
        try {
            scanner = new Scanner(System.in);

            boolean isMenuActive = true;
            while (isMenuActive) {
                printMenu();
                int action = Integer.parseInt(scanner.nextLine());
                switch (action) {
                    case 1 -> showAllProducts();
                    case 2 -> addProductToBucket();
                    case 3 -> showBucket();
                    case 4 -> deleteFromBucket();
                    case 5 -> clearBucket();
                    case 6 -> isMenuActive = false;
                    case 7 -> System.out.println("Invalid menu item");
                }
            }
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
