package dao;

import models.Departments;
import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);
    //void addDepartmentsToUser( Departments departments,User user);

    //read
    List<News> getAll();
    // List<News> getAllNewsForADepartments(int departmentid);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}

