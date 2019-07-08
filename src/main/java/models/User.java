package models;

import java.util.Objects;

public class User {
    private int id;
    private String position;
    private int departmentId;

    public User (String position, int departmentId){
        this.position=position;
        this.departmentId =departmentId;
    }


    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                departmentId == user.departmentId &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, departmentId);
    }

    public int getDepartmentId() {
        return departmentId;
    }


}
