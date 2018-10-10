package com.financialassets.persistence;

import com.financialassets.entity.UserAsset;
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


public class UserAssetDao {



    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Gets all UserAssets.
     *
     * @return List of UserAssets
     */
    public List<UserAsset> getAll() {
        // session/session factory
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // get all userAssets
        CriteriaQuery<UserAsset> query = builder.createQuery(UserAsset.class);
        Root<UserAsset> root = query.from(UserAsset.class);
        List<UserAsset> userAssets = session.createQuery(query).getResultList();

        session.close();
        return userAssets;

    }
    
    /**
     * Get by id userAsset.
     *
     * @param id the id
     * @return the userAsset
     */
    public UserAsset getById(int id){
        UserAsset userAsset;

        Session session = sessionFactory.openSession();
        userAsset = session.get(UserAsset.class, id);
        session.close();

        return userAsset;
    }


    /**
     * Save or update.
     *
     * @param userAsset the userAsset
     */
    public void saveOrUpdate(UserAsset userAsset) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(userAsset);
        session.close();
    }


    /**
     * Insert UserAsset.
     *
     * @param userAsset the userAsset
     * @return the userAsset id (int)
     */
    public int insert(UserAsset userAsset) {
        int insertedId = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        insertedId = (int)session.save(userAsset);
        transaction.commit();
        session.close();

        return insertedId;
    }


    /**
     * Delete.
     *
     * @param userAsset the userAsset to delete
     */
    public void delete(UserAsset userAsset) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userAsset);
        transaction.commit();
        session.close();
    }





    /**
     *  No Arg Constructor
     */
    public UserAssetDao() {
    }

}
