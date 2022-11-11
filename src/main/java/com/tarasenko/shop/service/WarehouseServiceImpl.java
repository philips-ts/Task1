package com.tarasenko.shop.service;

import com.tarasenko.shop.repository.FoodRepository;
import com.tarasenko.shop.repository.NotFoodRepository;
import com.tarasenko.shop.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final FoodRepository foodRepository;
    private final NotFoodRepository notFoodDao;

    @Override
    public Optional<Product> findProductByName(String productName) {
        if (productName == null) {
            return Optional.empty();
        }

        return getAllProducts().stream()
                .filter(product -> productName.equalsIgnoreCase(product.getName()))
                .map(Optional::of)
                .findFirst()
                .orElseGet(Optional::empty);
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return getAllProducts().stream()
                .filter(product -> product.getProductId() == id)
                .map(Optional::of)
                .findFirst()
                .orElseGet(Optional::empty);
    }

    @Override
    public List<Product> getAllProducts() {
        final List<Product> products = new ArrayList<>();
        products.addAll(foodRepository.findAll());
        products.addAll(notFoodDao.findAll());

        return products;
    }
}
