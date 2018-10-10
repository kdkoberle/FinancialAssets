package com.financialassets.test;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.UserAssetDao;
import com.financialassets.persistence.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;

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
        UserAsset userAsset = userAssetDao.getById(2);
        assertNotNull(userAsset);
        assertEquals("gold", userAsset.getAssetName());

    }


    /**
     * Test that save/update works and does change values
     */
    @Test
    void saveOrUpdate() {
        String newAssetName = "Gold";
        UserAsset toUpdate = userAssetDao.getById(3);
        toUpdate.setAssetName(newAssetName);
        userAssetDao.saveOrUpdate(toUpdate);

        UserAsset actualUserAsset = userAssetDao.getById(3);
        assertEquals(newAssetName, actualUserAsset.getAssetName());
    }


    /**
     * Test ability to add a new UserAsset to table
     */
    @Test
    void insert() {

        //double buyPrice = new BigDecimal(14.50).doubleValue();
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.getById(1);
        //assertEquals("Keith", user.getFirstName());
        BigDecimal buyPrice = new BigDecimal(14.50);
        UserAsset newUAsset = new UserAsset(user, buyPrice, LocalDate.now(), 50, "Silver");
        newUAsset.setAssetId(2);
        userAssetDao.insert(newUAsset);
        assertEquals(4, userAssetDao.getAll().size());

    }

    /**
     * Test that an entry is indeed deleeted
     */
    @Test
    void delete() {
        userAssetDao.delete(userAssetDao.getById(3));
        assertEquals(userAssetDao.getAll().size(), 2);
        assertNull(userAssetDao.getById(3));
    }
}

