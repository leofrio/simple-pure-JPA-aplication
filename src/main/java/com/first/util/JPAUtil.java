package com.first.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory factory= Persistence.createEntityManagerFactory("store");
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
