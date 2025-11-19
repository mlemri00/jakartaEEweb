package org.mons.dev.DAO.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.dev.models.User;
import org.mons.dev.util.ConnectionManager;

public class UserOrmImpl {
    public User getUser(String username){
        EntityManager em = ConnectionManager.getEntityManager();
        User user;
        Query query = em.createQuery("select u from User u where u.userName = :userName")
                .setParameter("userName",username);

        try {
            user = (User) query.getSingleResult();
        }catch (Exception e){
            return null;
        }

        em.close();
        return user;
    }



}
