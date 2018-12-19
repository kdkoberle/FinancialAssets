package com.financialassets.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DaoFactory<T> {
    private Class<T> type;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Dao factory.
     *
     * @param type the type of object for which to make a dao
     */
    public DaoFactory(Class<T> type) {
        this.type = type;
    }


    /**
     * create and return an opened session from SessionFactory
     *
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


    /**
     * Gets entity type by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the databaseEntity of specified type by id
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T databaseEntity = (T)session.get(type, id);
        session.close();
        return databaseEntity;
    }

    /**
     * Delete.
     *
     * @param entity the entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Gets all.
     *
     * @return List of all entities of type T
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> allT = session.createQuery(query).getResultList();
        session.close();
        return allT;
    }

    /**
     * Save or update.
     *
     * @param  entity of type T to be updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the assigned id of new entry
     */
    public int insert(T entity) {
        int insertedId = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        insertedId = (int)session.save(entity);
        transaction.commit();
        session.close();

        return insertedId;
    }

/*
    public List<T> selectWhere(String column, String value) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        List<T> elements = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();

        return  elements;
    }*/

}
