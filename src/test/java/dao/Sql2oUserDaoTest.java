package dao;

import models.Departments;
import models.News;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import org.sql2o.Connection;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private  Connection conn;
    private Sql2oUserDao userDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o =new Sql2o(connectionString,"roselyne","moraa@2018");
        userDao =new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setupNewUser();
        assertEquals(0,testUser.getId());
    }
    @Test
    public void addedUserAreReturnFromGetAll() throws Exception {
        User testUser = setupNewUser();
        userDao.add(testUser);
        assertEquals(1, userDao.getAll().size());
    }
    @Test
    public void noUserAreReturnEmptyList() throws Exception {
        assertEquals(1, userDao.getAll().size());
    }
    @Test
    public void  deleteByIdDeletesCorrectUser() throws Exception {
        User testUser = setupNewUser();
        User otherUser = setupNewUser();
        userDao.deleteById(testUser.getId());
        assertEquals(1, userDao.getAll().size());
    }
    @Test
    public void  clearAll() throws Exception {
        User testUser = setupNewUser();
        User otherUser = setupNewUser();
        userDao.clearAll();
        assertEquals(1, userDao.getAll().size());
    }
    public User setupNewUser() {
        return new  User("Accountant",1);
    }
}