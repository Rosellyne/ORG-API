package dao;

import models.DB;
import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentsDao  implements DepartmentsDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentsDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments (name,description,numberofemployees) VALUES (:name, :description, :numberOfEmployees)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Departments.class);
        }
    }
    @Override
    public  Departments findById(int id){
        String sql = "SELECT * FROM departments  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Departments.class);

        }
    }


//    @Override
//    public List<Departments> getAllUsersByDepartments(int restaurantId) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM reviews WHERE restaurantId = :restaurantId")
//                    .addParameter("restaurantId", restaurantId)
//                    .executeAndFetch(Departments.class);
//        }
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
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
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
