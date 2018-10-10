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

    /**
     *  Test that the get by id works with a known value
     */
    @Test
    void getById() {

    }


    /**
     * Test that save/update works and does change values
     */
    @Test
    void saveOrUpdate() {

    }


    /**
     * Test ability to add a new UserAsset to table
     */
    @Test
    void insert() {

    }

    /**
     * Test that an entry is indeed deleeted
     */
    @Test
    void delete() {

    }
}

