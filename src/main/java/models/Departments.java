package models;

import java.util.Objects;

public class Departments {
    private String name;
    private String description;
    private int numberOfEmployees;
    private  int id;


    public  Departments(String name, String description, int numberOfEmployees){
        this.name=name;
        this.description=description;
        this.numberOfEmployees=numberOfEmployees;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        Departments that = (Departments) o;
        return getNumberOfEmployees() == that.getNumberOfEmployees() &&
                getId() == that.getId() &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getNumberOfEmployees(), getId());
    }
}

