package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getPositionReturnsCorrectPosition() throws Exception {
        User testUser = setupUser();
        assertEquals("Finance officer", testUser.getPosition());
    }
    @Test
    public void getDepartmentIdReturnsCorrectDepartmentId() throws Exception {
        User testUser = setupUser();
        assertEquals(1, testUser.getDepartmentId());
    }




    public User setupUser (){
        return new User("Finance officer", 1);
    }
}