package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BucketDaoImpl implements BucketDao {
    private final List<OrderItem> orderItems = new ArrayList<>();

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
    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new RuntimeException("addProduct() parameter is null");
        }
        if (quantity < 1) {
            throw new RuntimeException("Quantity must be above 0");
        }

        final int index = getOrderItemIndexByProductName(product.getName());
        if (index == -1) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setProduct(product);
            newOrderItem.setQuantity(quantity);

            orderItems.add(newOrderItem);
        } else {
            OrderItem orderItem = orderItems.get(index);
            int newQuantity = orderItem.getQuantity() + quantity;
            orderItem.setQuantity(newQuantity);
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


    private int getOrderItemIndexById(int id) {
        int index = -1;

        for (int i = 0; i < orderItems.size(); i++) {
            if (orderItems.get(i).getProduct().getId() == id) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public boolean removeProductById(int id) {
        if (id <= 0) {
            throw new RuntimeException("removeProductById(): ID is incorrect");
        }

        final int index = getOrderItemIndexById(id);
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
}
