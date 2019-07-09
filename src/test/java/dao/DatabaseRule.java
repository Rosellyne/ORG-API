package dao;
import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
//import org.sql2o.*;





public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api_test", "roselyne","moraa@2018");
    }
    @Override
    protected void after(){
        try(Connection con= DB.sql2o.open()){
            String deleteDepartmentsQuery ="DELETE FROM departments*;";
            String deleteUserQuery="DELETE FROM users;";
            String deleteNewsQuery="DELETE FROM news;";
            con.createQuery(deleteDepartmentsQuery).executeUpdate();
            con.createQuery(deleteUserQuery).executeUpdate();
            con.createQuery(deleteNewsQuery).executeUpdate();
        }
    }


}
