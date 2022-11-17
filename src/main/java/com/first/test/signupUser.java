package com.first.test;

import com.first.DAO.UserDao;
import com.first.DAO.UserTypeDAO;
import com.first.demo.User;
import com.first.demo.UserType;
import com.first.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class signupUser {
    public static void main(String[] args) {
        NewUser();
        EntityManager em= JPAUtil.getEntityManager();
        em.getTransaction().begin();
        UserDao userDao=new UserDao(em);
        User secondUser = userDao.findUserByRegistration("951549927");
        System.out.println("second user:" + secondUser.getEmail());
        List<User> allUsers=userDao.getAllUsers();
        allUsers.forEach(u -> System.out.println(u.getEmail()));
        User leo= userDao.getUserByEmail("leogaspar01@hotmail.com");
        System.out.println("leos email is:" + leo.getEmail());
        User first=userDao.updateTypeFromRegistration("1910466","admin");
        User second=userDao.updateTypeFromRegistration("951549927","regular");
        List<User> admins=userDao.getUsersByType("admin");
        List<User> regulars=userDao.getUsersByType("regular");
        System.out.println("admins:");
        admins.forEach(u -> System.out.println(u.getEmail()));
        System.out.println("regulars:");
        regulars.forEach(u -> System.out.println(u.getEmail()));
        em.getTransaction().commit();
    }

    private static void NewUser() {
        User arnaldo=new User();
        arnaldo.setRegistration("1910422");
        arnaldo.setEmail("arnaldo@gmail.com");
        arnaldo.setPassword("GreatPeoplesPassword");
        UserType admin=new UserType("admin");
        UserType regular= new UserType("regular");
        EntityManager em= JPAUtil.getEntityManager();
        UserDao userDao=new UserDao(em);
        UserTypeDAO userTypeDAO=new UserTypeDAO(em);
        em.getTransaction().begin();
        userTypeDAO.addNewType(admin);
        userTypeDAO.addNewType(regular);
        arnaldo.setUserType(regular);
        userDao.addNewUser(arnaldo);
        em.getTransaction().commit();
        em.close();
    }
}
