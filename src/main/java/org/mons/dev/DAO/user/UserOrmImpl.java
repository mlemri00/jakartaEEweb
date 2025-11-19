package org.mons.dev.DAO.user;

import jakarta.persistence.EntityManager;
import org.mons.dev.models.User;
import org.mons.dev.util.ConnectionManager;

public class UserOrmImpl {
    public boolean validateUser(String userName, String password){
        EntityManager em = ConnectionManager.getEntityManager();


    return false;

    }



}
