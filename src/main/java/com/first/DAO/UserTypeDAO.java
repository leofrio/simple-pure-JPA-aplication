package com.first.DAO;

import com.first.demo.User;
import com.first.demo.UserType;

import javax.persistence.EntityManager;

public class UserTypeDAO {
    private EntityManager em;
    public UserTypeDAO(EntityManager em) {
        this.em = em;
    }
    public void addNewType(UserType type) {
        this.em.persist(type);
    }
    public UserType getTypeByName(String name) {
        String jpql="SELECT t FROM UserType t WHERE t.name = :name";
        return em.createQuery(jpql,UserType.class)
                .setParameter("name",name)
                .getSingleResult();
    }
    public UserType findTypeById(int id) {
        return this.em.find(UserType.class,id);
    }

}
