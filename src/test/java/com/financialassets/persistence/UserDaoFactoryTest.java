package com.financialassets.persistence;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoFactoryTest {

    Database database;
    DaoFactory userDao;
    User user;

    @BeforeEach
    void setup() {
        database = new Database();
        database.runSQL("cleandb.sql");
        database.runSQL("create_tables.sql");
        database.runSQL("insert.sql");

        userDao = new DaoFactory(User.class);
    }


    @Test
    void getById() {
        user = (User)userDao.getById(1);

        assertTrue(user.getEmail().equals("kdkoberle@madisoncollege.edu"));
    }

    @Test
    void delete() {
        user = (User)userDao.getById(1);
        userDao.delete(user);
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    void getAll() {
        assertEquals(1, userDao.getAll().size());
    }

    @Test
    void saveOrUpdate() {
        user = (User)userDao.getById(1);
        user.setEmail("kdkoberle@gmail.com");
        userDao.saveOrUpdate(user);

        assertTrue(((User) userDao.getById(1)).getEmail().equals("kdkoberle@gmail.com"));

    }

    @Test
    void insert() {
        User newUser = new User("jimmy@john.com", "123", "jim", "john");

        userDao.insert(newUser);


        assertEquals(2, userDao.getAll().size());

    }
}