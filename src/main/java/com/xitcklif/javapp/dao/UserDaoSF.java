//package com.xitcklif.javapp.dao;
//
//import com.xitcklif.javapp.model.User;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import javax.persistence.*;
//import java.util.List;
//
//@Repository
//public class UserDaoSF implements UserDao {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    public User userById(long id) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
//        query.setParameter("id", id);
//        return (User) query.getSingleResult();
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    @Override
//    public void update(long id, User user) {
//        User userForUpdate = userById(id);
//
//        userForUpdate.setFirstName(user.getFirstName());
//        userForUpdate.setLastName(user.getLastName());
//        userForUpdate.setEmail(user.getEmail());
//        userForUpdate.setDebt(user.getDebt());
//    }
//
//    @Override
//    public void rmUserById(Long id) {
//        sessionFactory.getCurrentSession().delete(
//                sessionFactory.getCurrentSession().createQuery(
//                        "from User where id = " + id).uniqueResult());
//    }
//}
