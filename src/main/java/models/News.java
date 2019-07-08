package models;

public class News {
    private int id;
    private String content;


    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public News(String content){
        this.content=content;
    }


}
