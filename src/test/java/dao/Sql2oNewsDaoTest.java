package dao;

import models.News;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private Connection conn;
    private Sql2oNewsDao newsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o =new Sql2o(connectionString,"roselyne","moraa@2018");
        newsDao =new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = setupNewNews();
        assertEquals(0,testNews.getId());
    }
    @Test
    public void addedUserAreReturnFromGetAll() throws Exception {
        News testNews = setupNewNews();
        newsDao.add(testNews);
        assertEquals(1, newsDao.getAll().size());
    }
    @Test
    public void noUserAreReturnEmptyList() throws Exception {
        assertEquals(1, newsDao.getAll().size());
    }
    @Test
    public void  deleteByIdDeletesCorrectUser() throws Exception {
        News testNews = setupNewNews();
        News otherNews = setupNewNews();
        newsDao.deleteById(testNews.getId());
        assertEquals(1, newsDao.getAll().size());
    }
    @Test
    public void  clearAll() throws Exception {
        News testNews = setupNewNews();
        News otherNews = setupNewNews();
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

//    @Test
//    public void  getAllNewsByDepartment() throws Exception {
//        News testNews = setupNewNews();
//        List<News> allNewsByDept =newsDao.getAllNewsForADepartments(News.getDepartmentId());
//        assertEquals(News.getDepartmentId, allNewsByDept.get(0).getDepartmentId());
//    }
    @Test
    public void findById() {
        News testnews = setupNewNews();
        assertEquals(testnews, newsDao.findById(testnews.getId()));
    }


    public News setupNewNews() {
        return new News("disease outbreak");
    }

}