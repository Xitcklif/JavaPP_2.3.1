package com.xitcklif.javapp.dao;

import com.xitcklif.javapp.model.User;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoEM implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) throws HibernateException {
        entityManager.persist(user);
    }

    @Override
    public User userById(long id) throws HibernateException {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() throws HibernateException {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void update(User user) throws HibernateException {
        entityManager.merge(user);
    }

    @Override
    public void rmUserById(Long id) throws HibernateException {
        entityManager.remove(userById(id));
    }
}
