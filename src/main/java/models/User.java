package models;

public class User {
    private int id;
    private String position;
    private int departmentId;


    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public User (String position, int departmentId){
        this.position=position;
        this.departmentId =departmentId;
    }
}
