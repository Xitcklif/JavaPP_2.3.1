package com.xitcklif.javapp.service;

import com.xitcklif.javapp.dao.UserDaoEM;
import com.xitcklif.javapp.model.User;

import org.hibernate.HibernateException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDaoEM userDao;

    public UserServiceImpl(UserDaoEM userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(rollbackFor = HibernateException.class)
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User userById(long id) {
        return userDao.userById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional(rollbackFor = HibernateException.class)
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional(rollbackFor = HibernateException.class)
    public void rmUserById(Long id) {
        userDao.rmUserById(id);
    }
}
