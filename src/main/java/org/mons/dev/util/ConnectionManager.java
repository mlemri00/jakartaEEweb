package org.mons.dev.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("moviesMySQL");


public static EntityManager getEntityManager(){
    return emf.createEntityManager();
}
}
