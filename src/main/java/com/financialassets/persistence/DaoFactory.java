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

public class DaoFactory<T> {
    private Class<T> type;

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Instantiates a new Dao factory.
     *
     * @param type the type of object for which to make a dao
     */
    public DaoFactory(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}
