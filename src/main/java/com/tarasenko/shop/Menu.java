package com.tarasenko.shop;

import com.tarasenko.shop.Warehouse.Warehouse;
import com.tarasenko.shop.bucket.Bucket;
import com.tarasenko.shop.currency.Currency;
import com.tarasenko.shop.model.Product;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Bucket bucket;
    private final Warehouse warehouse;
    private final List<Currency> currencies;

    public final double UAH_MULTIPLICITY = 1.2;

    public static final String WAREHOUSE_FILE_NAME = "warehouse";
    public static final String BUCKET_FILE_NAME = "bucket";

    private Scanner scanner;

    public Menu(Bucket bucket, Warehouse warehouse, List<Currency> currencies) {
        this.bucket = bucket;
        this.warehouse = warehouse;
        this.currencies = currencies;
    }

    private void showAllProducts() {
        warehouse.getProducts().forEach(System.out::println);
    }

    private void addProductToBucket() {
        System.out.println("Enter a product name to add to the bucket: ");
        String productName = scanner.nextLine();
        productName = productName.trim();

        for (Product product : warehouse.getProducts()) {
            if (productName.equals(product.getName())) {
                bucket.addProduct(product, 1);
                break;
            }
        }
    }

    private void showBucket() {
        System.out.println("Bucket: ");
        bucket.getOrderItems().forEach(System.out::println);
    }

    private void deleteFromBucket() {
        System.out.println("Enter a product name to add from the bucket: ");
        String productName = scanner.nextLine();
        productName = productName.trim();

        boolean isDeleted = bucket.removeProductByName(productName);
        if (isDeleted) {
            System.out.println("The product removed successfully");
        } else {
            System.out.println("The product was not found in the bucket");
        }
    }

    private void clearBucket() {
        bucket.clear();
    }


    private void buyProducts() {
        int totalCost = bucket.getTotalCost();
        totalCost *= UAH_MULTIPLICITY;
        System.out.println("Total cost the products in the bucket: " + totalCost + " UAH");
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
                                6. Buy products from the bucket
                                7. Exit
                                ---------------------------------------------------
                                """);
    }


    public void showMenu() {
        bucket.load(BUCKET_FILE_NAME);
        warehouse.load(WAREHOUSE_FILE_NAME);

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
                    case 6 -> buyProducts();
                    case 7 -> {
                        bucket.save(BUCKET_FILE_NAME);
                        warehouse.save(WAREHOUSE_FILE_NAME);
                        isMenuActive = false;
                    }
                    default -> System.out.println("Invalid menu item!");
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
