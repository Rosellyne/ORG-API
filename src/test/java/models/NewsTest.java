package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContent() {
        News testNews = setupNews();
        assertEquals("water storage", testNews.getContent());
    }
    @Test
    public void setContent() {
        News testNews = setupNews();
        testNews.setContent("disease outbreak");
        assertNotEquals("water storage", testNews.getContent());
    }
    @Test
    public void setId() {
        News testNews = setupNews();
        testNews.setId(2);
        assertEquals(2, testNews.getId());
    }


    public News setupNews() {
        return new News("water storage");

    }
}