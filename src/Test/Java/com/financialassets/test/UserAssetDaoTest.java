package com.financialassets.test;

import com.financialassets.persistence.UserAssetDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAssetDaoTest {

    UserAssetDao userAssetDao;

    /**
     * create a new BookDao before each test
     */
    @BeforeEach
    void setUp() {
        com.financialassets.test.util.Database database = com.financialassets.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        userAssetDao = new UserAssetDao();
    }

    /**
     * Test the getAll function returns correct number
     */
    @Test
    void getAll() {
        assertEquals(3, userAssetDao.getAll().size());
    }

    @Test
    void getById() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }
}

