package com.tarasenko.shop.service;

import com.tarasenko.shop.dao.NotFoodDao;
import com.tarasenko.shop.dto.NotFoodDto;
import com.tarasenko.shop.entity.NotFood;
import com.tarasenko.shop.mapper.NotFoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotFoodServiceImpl implements NotFoodService {

    private NotFoodDao notFoodDao;
    private NotFoodMapper notFoodMapper;

    @Autowired
    public NotFoodServiceImpl(NotFoodDao notFoodDao, NotFoodMapper notFoodMapper) {
        this.notFoodDao = notFoodDao;
        this.notFoodMapper = notFoodMapper;
    }

    @Override
    public void addNotFood(NotFoodDto notFoodDto) {
        NotFood notFood = notFoodMapper.toEntity(notFoodDto);
        notFoodDao.add(notFood);
    }

    @Override
    public List<NotFoodDto> getAllNotFood() {
        List<NotFood> allNotFood = notFoodDao.getAll();
        List<NotFoodDto> notFoodDtos = notFoodMapper.toDto(allNotFood);

        return notFoodDtos;
    }

    @Override
    public void removeNotFood(int id) {
        notFoodDao.deleteById(id);
    }
}
