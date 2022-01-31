package com.xitcklif.javapp.dao;

import com.xitcklif.javapp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User userById(long id);
    List<User> listUsers();
    void update(long id, User user);
    void rmUserById(Long id);
}