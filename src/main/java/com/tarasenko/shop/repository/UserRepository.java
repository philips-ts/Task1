package com.tarasenko.shop.repository;

import com.tarasenko.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("from User where isActive=true")
    User getActiveUser();
}
