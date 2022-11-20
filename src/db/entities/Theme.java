package db.entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Basic;

@Entity
@Table(name = "themes", schema = "", catalog = "") //schema to specify later
public class Theme {
    @Id
    @Column
    private long theme_id;
    @Basic
    @Column(nullable = false)
    private String theme;

    public Theme(){

    }
    public Theme(long theme_id, String theme) {
        this.theme_id = theme_id;
        this.theme = theme;
    }

    public long getId() {
        return theme_id;
    }

    public void setId(long theme_id) {
        this.theme_id = theme_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}

