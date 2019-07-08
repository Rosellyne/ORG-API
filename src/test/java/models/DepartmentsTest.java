package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals("Finance", testDepartments.getName());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals("deals with maintaining company finances", testDepartments.getDescription());
    }

    @Test
    public void getNumberOfEmployeesReturnsCorrectValue() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals(60, testDepartments.getNumberOfEmployees());
    }


    public Departments setupDepartments (){
        return new Departments("Finance", "deals with maintaining company finances ", 60);
    }
}