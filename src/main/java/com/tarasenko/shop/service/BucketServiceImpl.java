package com.tarasenko.shop.service;

import com.tarasenko.shop.dao.BucketDao;
import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BucketServiceImpl implements BucketService {

    private final BucketDao bucketDao;

    @Autowired
    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public void addProduct(Product product, int quantity) {
        bucketDao.addProduct(product, quantity);
    }

    @Override
    public boolean removeProductById(int id) {
        return bucketDao.removeProductById(id);
    }


    @Override
    public List<OrderItem> getOrderItems() {
        return bucketDao.getOrderItems();
    }

    @Override
    public void clear() {
        bucketDao.clear();
    }

    @Override
    public int getTotalCost() {
        int totalCost = 0;
        for (OrderItem orderItem : getOrderItems()) {
            totalCost += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }

        return totalCost;
    }

    @Override
    public boolean removeProductByName(String productName) {
        return bucketDao.removeProductByName(productName);
    }
}
