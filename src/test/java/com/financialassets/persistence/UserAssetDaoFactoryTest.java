package com.financialassets.persistence;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAssetDaoFactoryTest {

    Database database;
    DaoFactory userAssetDao;
    UserAsset userAsset;


    @BeforeEach
    void setup() {
        database = new Database();
        database.runSQL("cleandb.sql");
        database.runSQL("create_tables.sql");
        database.runSQL("insert.sql");

        userAssetDao = new DaoFactory(UserAsset.class);
    }

    @Test
    void getById() {
        userAsset = (UserAsset)userAssetDao.getById(4);
        assertTrue(userAsset.getAssetName().equals("INTC"));
    }

    @Test
    void delete() {
        userAsset = (UserAsset)userAssetDao.getById(4);
        userAssetDao.delete(userAsset);

        assertNull((UserAsset)userAssetDao.getById(4));
    }

    @Test
    void getAll() {
        List<UserAsset> allUserAssets = userAssetDao.getAll();

        assertEquals(5, allUserAssets.size());
    }

    @Test
    void saveOrUpdate() {
        userAsset = (UserAsset)userAssetDao.getById(4);

        userAsset.setAssetName("STM");

        userAssetDao.saveOrUpdate(userAsset);

        assertTrue(((UserAsset) userAssetDao.getById(4)).getAssetName().equals("STM"));

    }

    @Test
    void insert() {

        DaoFactory userDao = new DaoFactory(User.class);
        User user = (User)userDao.getById(1);
        UserAsset newAsset = new UserAsset();
        newAsset.setAssetName("INTC");
        newAsset.setFees(9.90);
        newAsset.setBuyDate(LocalDate.now());
        newAsset.setBuyPrice(18.95);
        newAsset.setQty(30);
        newAsset.setUser(user);

        userAssetDao.insert(newAsset);

        assertEquals(6, userAssetDao.getAll().size());


    }
}