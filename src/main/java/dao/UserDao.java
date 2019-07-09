package dao;

import models.User;

import java.util.List;

public interface UserDao {

    //create
    void add(User user);
    //void addUserToDepartments(User user, Departments departments);

    //read
    List<User> getAll();
    // List<Departments> getAllDepartmentsForAUser(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
