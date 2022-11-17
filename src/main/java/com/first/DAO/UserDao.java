package com.first.DAO;

import com.first.demo.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {
    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }
    public void addNewUser(User user) {
        this.em.persist(user);
    }
    public User findUserByRegistration(String registration) {
        return this.em.find(User.class,registration);
    }
    public List<User> getAllUsers() {
        String jpql="SELECT u FROM User u";
        return em.createQuery(jpql,User.class).getResultList();
    }
    public User getUserByEmail(String email) {
        String jpql="SELECT u FROM User u WHERE u.email = :email";
        return em.createQuery(jpql,User.class)
                .setParameter("email",email)
                .getSingleResult();
    }
    public User updateTypeFromRegistration(String registration,String type) {
        User current=this.findUserByRegistration(registration);
        UserTypeDAO userTypeDAO=new UserTypeDAO(em);
        current.setUserType(userTypeDAO.getTypeByName(type));
        System.out.println(current.getRegistration() + " " + current.getEmail() + " "
        + current.getPassword() + " " + current.getUserType());
        return em.merge(current);
    }
    public List<User> getUsersByType(String type) {
        String jpql="SELECT u FROM User u WHERE u.userType.name = :type";
        return em.createQuery(jpql,User.class)
                .setParameter("type",type)
                .getResultList();
    }
}
