package com.financialassets.persistence;
import com.financialassets.entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {




    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Get by id user.
     *
     * @param id the id
     * @return the user
     */
    public User getById(int id){
        User user;

        Session session = sessionFactory.openSession();
        user = session.get(User.class, id);
        session.close();

        return user;
    }


    /**
     * Save or update.
     *
     * @param user the user
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }


    /**
     * Insert User.
     *
     * @param user the user
     * @return the user id (int)
     */
    public int insert(User user) {
        int insertedId = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        insertedId = (int)session.save(user);
        transaction.commit();
        session.close();

        return insertedId;
    }


    /**
     * Delete.
     *
     * @param user the user to delete
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }





    /**
     *  No Arg Constructor
     */
    public UserDao() {
    }

}
