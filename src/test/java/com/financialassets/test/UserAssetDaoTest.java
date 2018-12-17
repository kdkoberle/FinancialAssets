package com.financialassets.test;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.DaoFactory;
import com.financialassets.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserAssetDoaFactoryTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    DaoFactory daoFactory;
    Database db;
    /**
     * create a new DaoFactory for UserAsset before each test
     */
    @BeforeEach
    void setUp() {
        com.financialassets.test.util.Database database = com.financialassets.test.util.Database.getInstance();
        //database.runSQL("cleandb.sql");

        daoFactory = new DaoFactory(UserAsset.class);
    }

    /**
     * Test that the getAll function returns correct number
     */
    @Test
    void testGetAll() {
        List<UserAsset> allUserAssets;
        allUserAssets = daoFactory.getAll();
        assertEquals(5, allUserAssets.size());

    }
    /**
     *  Test that the get by id works with a known value
     */
    @Test
    void testGetById() {
        UserAsset userAsset = (UserAsset)daoFactory.getById(7);
        assertNotNull(userAsset);
        assertEquals("AU", userAsset.getAssetName());
    }



    /**
     * Test that save/update works and does change values
     */
    //TODO get this test working
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

    @Test
    void testInsert() {
        DaoFactory userDaoFactory = new DaoFactory(User.class);
        User user = new User();
        user = (User)userDaoFactory.getById(1);
        assertEquals("Keith", user.getFirstName());
        BigDecimal buyPrice = new BigDecimal(14.50);
        UserAsset newUAsset = new UserAsset(user, buyPrice, LocalDate.now(), 50, "Silver");
        newUAsset.setAssetId(2);
        daoFactory.insert(newUAsset);
        assertEquals(4, daoFactory.getAll().size());
    }

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

