package com.financialassets.persistence;

import com.financialassets.entity.Asset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AssetDao {




    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get asset by id
     * @param id int, the id of the asset in the database (pri key)
     */
    public Asset getById(int id) {
        Asset asset;
        // session/session factory
        Session session = sessionFactory.openSession();
        asset = session.get(Asset.class, id);
        session.close();

        return asset;
    }


    /**
     * update asset
     * @param asset  asset to be inserted or updated
     */
    public void saveOrUpdate(Asset asset) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(asset);
        session.close();
    }


    /**
     * update asset
     * @param asset  asset to be inserted or updated
     * @return id of new asset as per AUTO increment
     */
    public int insert(Asset asset) {
        int insertedId = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        insertedId = (int)session.save(asset);
        transaction.commit();
        session.close();
        return insertedId;
    }


    /**
     * Delete a asset
     * @param asset asset to be deleted
     */
    public void delete(Asset asset) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(asset);
        transaction.commit();
        session.close();
    }


    /** Return a list of all assets
     *
     * @return All assets
     */
    public List<Asset> getAll() {
        // session/session factory
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // get all assets
        CriteriaQuery<Asset> query = builder.createQuery(Asset.class);
        Root<Asset> root = query.from(Asset.class);
        List<Asset> assets = session.createQuery(query).getResultList();

        session.close();
        return assets;
    }

    /**
     * No Arg Constructor
     */
    public AssetDao() {
    }

}
