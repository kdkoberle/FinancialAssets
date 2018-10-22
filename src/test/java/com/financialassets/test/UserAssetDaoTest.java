package com.financialassets.test;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.DaoFactory;
import com.financialassets.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoaFactoryTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    DaoFactory daoFactory;

    /**
     * create a new BookDao before each test
     */
    @BeforeEach
    void setUp() {
        com.financialassets.test.util.Database database = com.financialassets.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        daoFactory = new DaoFactory(UserAsset.class);
    }

    /**
     * Test that the getAll function returns correct number
     */
    @Test
    void testGetAll() {
        List<UserAsset> allUserAssets;
        allUserAssets = daoFactory.getAll();
        assertEquals(3, allUserAssets.size());
    }

    /**
     *  Test that the get by id works with a known value
     */
    @Test
    void testGetById() {
        UserAsset userAsset = (UserAsset)daoFactory.getById(2);
        assertNotNull(userAsset);
        assertEquals("gold", userAsset.getAssetName());

    }



    /**
     * Test that save/update works and does change values
     */

    @Test
    void testSaveOrUpdate() {
        String newAssetName = "Gold";
        UserAsset userAssetToUpdate = (UserAsset)daoFactory.getById(3);
        userAssetToUpdate.setAssetName("Gold");
        daoFactory.saveOrUpdate(userAssetToUpdate);


        // test hasn't added another entry
        assertEquals(3, daoFactory.getAll().size());

        UserAsset dbUserAsset = (UserAsset)daoFactory.getById(3);
        assertEquals(newAssetName, dbUserAsset.getAssetName());
    }

    /**
     * Test ability to add a new UserAsset to table
     */
/**
    @Test
    void testInsert() {
        User user = new User();
        user = userDao.getById(1);
        //assertEquals("Keith", user.getFirstName());
        BigDecimal buyPrice = new BigDecimal(14.50);
        UserAsset newUAsset = new UserAsset(user, buyPrice, LocalDate.now(), 50, "Silver");
        newUAsset.setAssetId(2);
        DaoFactory.insert(newUAsset);
        assertEquals(4, DaoFactory.getAll().size());

    }*/

    /**
     * Test that an entry is indeed deleted
     */

    @Test
    void testDelete() {
        daoFactory.delete(daoFactory.getById(3));
        assertEquals(daoFactory.getAll().size(), 2);
        assertNull(daoFactory.getById(3));
    }
}

