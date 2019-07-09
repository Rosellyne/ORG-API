package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }




    @Override
    public void add(User user) {
        String sql = "INSERT INTO departments (name,description,numberofemployees) VALUES (:name, :description, :numberofemployees)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM user")
                    .executeAndFetch(User.class);
        }
    }


//    @Override
//    public List<User> getAllUsersByDepartments(int departmentId) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM user WHERE departmentId = :departmentId")
//                    .addParameter("departmentId", departmentId)
//                    .executeAndFetch(User.class);
//        }
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from user WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void clearAll() {
        String sql = "DELETE from user";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}


