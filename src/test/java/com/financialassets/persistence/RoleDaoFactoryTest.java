package com.financialassets.persistence;

import com.financialassets.entity.Role;
import com.financialassets.entity.UserAsset;
import com.financialassets.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoFactoryTest {

    Database database;
    DaoFactory roleDao;
    Role role;

    @BeforeEach
    void setup() {
        database = new Database();
        database.runSQL("cleandb.sql");
        database.runSQL("create_tables.sql");
        database.runSQL("insert.sql");

        roleDao = new DaoFactory(Role.class);
    }


    @Test
    void getById() {
        role = (Role)roleDao.getById(1);
        assertTrue(role.getEmail().equals("kdkoberle@madisoncollege.edu"));
    }

    @Test
    void delete() {
        role = (Role)roleDao.getById(1);

        roleDao.delete(role);

        assertNull(roleDao.getById(1));
    }

    @Test
    void getAll() {

        assertEquals(1, roleDao.getAll().size());

    }

    @Test
    void saveOrUpdate() {
        role = (Role)roleDao.getById(1);

        role.setRole("registered-user");

        roleDao.saveOrUpdate(role);

        assertTrue(((Role) roleDao.getById(1)).getRole().equals("registered-user"));

    }

    @Test
    void insert() {
        role = (Role)roleDao.getById(1);
        role.setRole("registered-user");

        roleDao.insert(role);

        Role newRole = (Role)roleDao.getById(2);

        assertTrue(newRole.getRole().equals("registered-user"));

    }
}