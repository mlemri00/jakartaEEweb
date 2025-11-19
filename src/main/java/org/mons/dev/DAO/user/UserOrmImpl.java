package org.mons.dev.DAO.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.dev.models.User;
import org.mons.dev.util.ConnectionManager;

public class UserOrmImpl {
    public User getUser(String username){
        EntityManager em = ConnectionManager.getEntityManager();
        Query query = em.createQuery("select u from User u where u.userName = :userName")
                .setParameter("userName",username);
        System.out.println("------------------------------------------------------------------asdfas-dfasdfasdfasdfasdf");
        User user = (User) query.getSingleResult();
        System.out.println("-----------------------------    "+ user.getFirstName() + "    ------------------");
        return user;
    }



}
