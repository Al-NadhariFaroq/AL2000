package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Themes")
@Table(name = "THEMES", schema = "ALNADHAF", catalog = "")
public class ThemePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEME_ID")
    private int themeId;
    @Basic
    @Column(name = "NAME")
    private String name;

    public ThemePOJO() {

    }

    public ThemePOJO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String theme) {
        this.name = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ThemePOJO)) {
            return false;
        }
        ThemePOJO themePOJO = (ThemePOJO) o;
        return themeId == themePOJO.themeId && Objects.equals(name, themePOJO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeId, name);
    }
}
