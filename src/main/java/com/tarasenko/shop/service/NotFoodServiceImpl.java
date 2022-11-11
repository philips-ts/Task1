package com.tarasenko.shop.service;

import com.tarasenko.shop.repository.NotFoodRepository;
import com.tarasenko.shop.dto.NotFoodDto;
import com.tarasenko.shop.entity.NotFood;
import com.tarasenko.shop.mapper.NotFoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotFoodServiceImpl implements NotFoodService {
    private final NotFoodRepository notFoodRepository;
    private final NotFoodMapper notFoodMapper;

    @Override
    public void addNotFood(NotFoodDto notFoodDto) {
        NotFood notFood = notFoodMapper.toEntity(notFoodDto);
        notFoodRepository.save(notFood);
    }

    @Override
    public List<NotFoodDto> getAllNotFood() {
        List<NotFood> allNotFood = notFoodRepository.findAll();

        return notFoodMapper.toDto(allNotFood);
    }

    @Override
    public void removeNotFood(int id) {
        notFoodRepository.deleteById(id);
    }
}
