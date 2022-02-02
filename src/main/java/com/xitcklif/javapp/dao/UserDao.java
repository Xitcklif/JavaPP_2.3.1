package com.xitcklif.javapp.dao;

import com.xitcklif.javapp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User userById(long id);
    List<User> listUsers();
    void update(User user);
    void rmUserById(Long id);
}