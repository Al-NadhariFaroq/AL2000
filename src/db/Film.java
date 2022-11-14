package db;

public class Film {
    int Id ;
    String title;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
