package com.tarasenko.shop.service;


import com.tarasenko.shop.entity.BucketItem;
import com.tarasenko.shop.entity.Order;
import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.User;
import com.tarasenko.shop.repository.BucketItemRepository;
import com.tarasenko.shop.repository.OrderItemRepository;
import com.tarasenko.shop.repository.OrderRepository;
import com.tarasenko.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final BucketItemRepository bucketItemRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;



    private List<OrderItem> getOrderItemsFromBucketItems(User activeUser) {
        List<BucketItem> bucketItems =
                bucketItemRepository.findBucketItemByUserUserId(activeUser.getUserId());

        List<OrderItem> orderItems = new ArrayList<>();
        for (BucketItem bucketItem : bucketItems) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setProduct(bucketItem.getProduct());
            newOrderItem.setQuantity(bucketItem.getQuantity());

            orderItems.add(newOrderItem);
        }

        return orderItems;
    }

    @Override
    public void createOrder(String deliveryAddress) {
        User activeUser = userRepository.getActiveUser();
        if (activeUser == null) {
            throw new RuntimeException("No active user found!");
        }

        List<OrderItem> orderItems = getOrderItemsFromBucketItems(activeUser);

        Order newOrder = new Order();
        newOrder.setUser(activeUser);
        newOrder.setDate(LocalDate.now());
        newOrder.setDeliveryAddress(deliveryAddress);
        newOrder.setOrderItems(orderItems);

        orderRepository.save(newOrder);
    }
}
