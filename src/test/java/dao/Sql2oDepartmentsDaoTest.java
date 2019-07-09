package dao;

import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;

import org.sql2o.Connection;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {
    private Sql2oDepartmentsDao departmentsDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "roselyne", "moraa@2018");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        departmentsDao.clearAll();
        conn.close();
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Departments testDepartments = setupNewDepartments();
        departmentsDao.add(testDepartments);
        int originalDepartmentsId = testDepartments.getId();
        assertEquals(originalDepartmentsId, testDepartments.getId());
    }

    @Test
    public void addedDepartmentAreReturnedFromGetAll() throws Exception {
        Departments testDepartments = setupNewDepartments();
        departmentsDao.add(testDepartments);
        assertEquals(1, departmentsDao.getAll().size());
    }

    @Test
    public void noDepartmentAreReturnedEmptyList() throws Exception {
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Departments testDepartments = setupNewDepartments();
        departmentsDao.add(testDepartments);
        departmentsDao.deleteById(testDepartments.getId());
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Departments testDepartments = setupNewDepartments();
        Departments otherDepartments = setupNewDepartments();
        departmentsDao.clearAll();
        assertEquals(0, departmentsDao.getAll().size());
    }


    public Departments setupNewDepartments() {
        return new Departments("money", "maintaining company finances ", 60);
    }
}