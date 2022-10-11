package com.tarasenko.shop.bucket;

import com.tarasenko.shop.model.OrderItem;
import com.tarasenko.shop.model.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BucketImpl implements Bucket {
    private List<OrderItem> orderItems = new ArrayList<>();

    private int getOrderItemIndexByProductName(String productName) {
        int index = -1;

        for (int i = 0; i < orderItems.size(); i++) {
            if (orderItems.get(i).getProduct().getName().equals(productName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public void addProduct(Product product, int amount) {
        if (product == null) {
            throw new RuntimeException("addProduct() parameter is null");
        }
        if (amount < 1) {
            throw new RuntimeException("Amount must be above 0");
        }

        final int index = getOrderItemIndexByProductName(product.getName());
        if (index == -1) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setProduct(product);
            newOrderItem.setAmount(amount);

            orderItems.add(newOrderItem);
        } else {
            OrderItem orderItem = orderItems.get(index);
            int newAmount = orderItem.getAmount() + amount;
            orderItem.setAmount(newAmount);
        }
    }


    @Override
    public boolean removeProductByName(String productName) {
        if (productName == null) {
            throw new RuntimeException("removeProduct() parameter is null");
        }

        final int index = getOrderItemIndexByProductName(productName);
        if (index != -1) {
            orderItems.remove(index);

            return true;
        }

        return false;
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return List.copyOf(orderItems);
    }


    @Override
    public void clear() {
        orderItems.clear();
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (OrderItem orderItem : orderItems) {
            totalCost += orderItem.getProduct().getPrice() * orderItem.getAmount();
        }

        return totalCost;
    }

    @Override
    public boolean save(String fileName) {
        boolean result = true;

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(orderItems);
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
            orderItems = (ArrayList<OrderItem>)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            result = false;
        }

        return result;
    }
}
