package com.tarasenko.shop.service;

import com.tarasenko.shop.entity.BucketItem;
import com.tarasenko.shop.entity.User;
import com.tarasenko.shop.repository.BucketItemRepository;
import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;
import com.tarasenko.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService {
    private final BucketItemRepository bucketItemRepository;
    private final UserRepository userRepository;


    private void checkActiveUser(User activeUser) {
        if (activeUser == null) {
            throw new RuntimeException("No active user found!");
        }
    }


    @Override
    public void addProduct(Product productDto, int quantity) {
        User activeUser = userRepository.getActiveUser();
        checkActiveUser(activeUser);

        List<BucketItem> bucketItemList =
                bucketItemRepository.findBucketItemByProduct_ProductIdAndUserUserId(
                        productDto.getProductId(), activeUser.getUserId());
        if (bucketItemList.isEmpty()) {
            BucketItem bucketItem = new BucketItem();
            bucketItem.setProduct(productDto);
            bucketItem.setUser(activeUser);
            bucketItem.setQuantity(quantity);

            bucketItemRepository.save(bucketItem);
        } else {
            BucketItem bucketItem = bucketItemList.get(0);
            int oldQuantity = bucketItem.getQuantity();
            int newQuantity = oldQuantity + quantity;
            bucketItem.setQuantity(newQuantity);

            bucketItemRepository.save(bucketItem);
        }
    }

    @Override
    public List<BucketItem> getBucketItems() {
        User activeUser = userRepository.getActiveUser();
        checkActiveUser(activeUser);

        return bucketItemRepository.findBucketItemByUserUserId(activeUser.getUserId());
    }

    @Override
    public void clear() {
        User activeUser = userRepository.getActiveUser();
        checkActiveUser(activeUser);

        bucketItemRepository.deleteBucketItemByUserUserId(activeUser.getUserId());
    }

    @Override
    public int getTotalCost() {
        int totalCost = 0;
        for (BucketItem bucketItem : getBucketItems()) {
            totalCost += bucketItem.getProduct().getPrice() * bucketItem.getQuantity();
        }

        return totalCost;
    }
}
