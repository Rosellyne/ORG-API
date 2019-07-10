package models;

import java.util.Objects;

public class News {
    private int id;
    private String content;
    private  int departmentId;

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return id;
    }
    public News(String content, int departmentId) {
        this.content = content;
        this.departmentId=departmentId;
    }

    public void setContent(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }




}
