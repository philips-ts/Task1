package com.tarasenko.shop.repository;

import com.tarasenko.shop.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
