package com.tarasenko.shop.repository;

import com.tarasenko.shop.entity.BucketItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketItemRepository extends JpaRepository<BucketItem, Integer> {
    List<BucketItem> findBucketItemByProduct_ProductIdAndUserUserId(int productId, int userId);

    List<BucketItem> findBucketItemByUserUserId(int userId);

    void deleteBucketItemByUserUserId(int userId);
}
