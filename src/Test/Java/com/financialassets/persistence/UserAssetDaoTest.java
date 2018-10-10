package com.financialassets.persistence;

import com.financialassets.persistence.UserAssetDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAssetDaoTest {


    /**
     * Do setup before each test
     */
    @BeforeEach
    void setUp() {
        com.financialassets.test.util.Database database = com.financialassets.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        UserAssetDao userAssetDao = new UserAssetDao();
    }





}
