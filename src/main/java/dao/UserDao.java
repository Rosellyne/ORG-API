package dao;

import models.Departments;
import models.User;

import java.util.List;

public interface UserDao {

    //create
    void add(User user);

    //read
    List<User> getAll();
    List<User> getAllUserByDepartments(int departmentId);
    User findById(int id);


    //delete
    void deleteById(int id);
    void clearAll();
}
