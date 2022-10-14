package com.tarasenko.shop.Warehouse;

import com.tarasenko.shop.model.ExpireDate;
import com.tarasenko.shop.model.Food;
import com.tarasenko.shop.model.NotFood;
import com.tarasenko.shop.model.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WarehouseImpl implements Warehouse {
    private ArrayList<Product> products;

    public WarehouseImpl() {
        products = new ArrayList<>();
    }

    public WarehouseImpl(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .map(Optional::of)
                .findFirst()
                .orElseGet(Optional::empty);
    }

    @Override
    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    private void checkForExpiration(Product product) {
        Field[] fields = product.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExpireDate.class)) {
                field.setAccessible(true);
                try {
                    if (product instanceof NotFood) {
                        field.setInt(product, 30);
                    } else if (product instanceof Food) {
                        field.setInt(product, 7);
                    }
                }catch (IllegalAccessException ignored) {
                }
            }
        }
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            throw new RuntimeException("AddProduct parameter is null");
        }
        if (!products.contains(product)) {
            checkForExpiration(product);
            products.add(product);
        }
    }

    @Override
    public boolean removeProductByName(String productName) {
        if (productName == null) {
            throw new RuntimeException("removeProduct() parameter is null");
        }

       Optional<Product> productOptional = getProductByName(productName);
       if (productOptional.isPresent()) {
            products.remove(productOptional.get());
            return true;
        }

       return false;
    }


    @Override
    public boolean save(String fileName) {
        boolean result = true;

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            result = false;
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean load(String fileName) {
        boolean result = true;

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            products = (ArrayList<Product>)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            result = false;
        }

        return result;
    }
}
