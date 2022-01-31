package com.xitcklif.javapp.service;

import com.xitcklif.javapp.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User userById(long id);
    List<User> listUsers();
    void update(long id, User user);
    void rmUserById(Long id);
}