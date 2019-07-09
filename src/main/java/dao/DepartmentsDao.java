package dao;

import models.Departments;
import models.User;

import java.util.List;

public interface DepartmentsDao {
    //create
    void add(Departments departments);
    //void addDepartmentsToUser( Departments departments,User user);

    //read
    List<Departments> getAll();
    // List<User> getAllUserForADepartments(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}

