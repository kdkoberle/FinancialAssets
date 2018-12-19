package com.financialassets.persistence;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insert() {
    }
}