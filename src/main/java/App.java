import com.google.gson.Gson;

import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.ApiException;
import models.Departments;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oUserDao userDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();


        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/org_api";
        Sql2o sql2o = new Sql2o(connectionString, "roselyne", "moraa@2018");

        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        userDao= new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();


        post("/departments/:departmentId/users/new", "application/json", (req, res) -> {
            int depaermentId = Integer.parseInt(req.params("departmentId"));
            User users= gson.fromJson(req.body(), User.class);

            users.setDepartmentId(depaermentId); //we need to set this separately because it comes from our route, not our JSON input.
            userDao.add(users);
            res.status(201);
            return gson.toJson(users);
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        //READ
        get("/news", "application/json", (req, res) -> {
            System.out.println(newsDao.getAll());

            if(newsDao.getAll().size() > 0){
                return gson.toJson(newsDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no restaurants are currently listed in the database.\"}";
            }

        });

        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentsDao.findById(departmentId));
        });

        get("/departments/:id/user", "application/json", (req, res) -> {
            int deparmentId = Integer.parseInt(req.params("id"));

            Departments DepartmentToFind = departmentsDao.findById(deparmentId);
            List<User> allUsers;

            if (DepartmentToFind == null){
                throw new ApiException(404, String.format("No departments with the id: \"%s\" exists", req.params("id")));
            }

            allUsers = userDao.getAllUserByDepartments(deparmentId);

            return gson.toJson(allUsers);
        });

        get("/users", "application/json", (req, res) -> {
            return gson.toJson(userDao.getAll());
        });


        //CREATE

        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(departments);
            res.status(201);
            return gson.toJson(departments);
        });


        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.type("application/json");
            res.body(gson.toJson(jsonMap));
        });

//
//        after((req, res) ->{
//            res.type("application/json");
//        });



        //TEMPLATES

        get("/forms",(request, response) -> {
            Map<String,Object> model =new HashMap<>();
            return  new ModelAndView(model,"forms.hbs");
        }, new HandlebarsTemplateEngine());


        post("/department/new",(request, response) -> {
            Map<String,Object> model =new HashMap<>();
            String  name =request.queryParams("name");
            String description = request.queryParams("description");
            int employees =Integer.parseInt(request.queryParams("employees"));
            Departments newDepartments = new Departments(name,description,employees);
            departmentsDao.add(newDepartments)
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get ("/department",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            model.put("departments",departmentsDao.getAll());
            return new ModelAndView(model,"dept.hbs");
        },new HandlebarsTemplateEngine());

        post("/news/new",(request, response) -> {
            Map<String,Object> model =new HashMap<>();
            String  news =request.queryParams("news");
            int departmentId =Integer.parseInt(request.queryParams("departmentId"));
            News newNews = new News(news,departmentId);
            newsDao.add(newNews);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get ("/news",(request, response) -> {
                    Map<String,Object>model =new HashMap<>();
                    model.put("news",newsDao.getAll());
                    return new ModelAndView(model,"news.hbs");
                },new HandlebarsTemplateEngine());

        post("/user/new",(request, response) -> {
            Map<String,Object> model =new HashMap<>();
            String  position =request.queryParams("position");
            int departmentId =Integer.parseInt(request.queryParams("departmentId"));
            User newUser = new User(position,departmentId);
           userDao.add(newUser);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get ("/users",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            model.put("users",userDao.getAll());
            return new ModelAndView(model,"user.hbs");
        },new HandlebarsTemplateEngine());

    }
}



