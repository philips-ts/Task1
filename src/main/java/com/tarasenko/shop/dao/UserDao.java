package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);
    List<User> getUsers();
    void addUser(User user);
    void deleteUserById(int id);
}
