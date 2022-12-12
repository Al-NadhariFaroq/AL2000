package db.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "themes")
@Table(name = "themes", schema = "rocd", catalog = "")
public class ThemePOJO implements POJO {
    @Id
    @Column(name = "theme_id")
    private int themeId;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<MovieThemePOJO> moviesTheme;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<PreferencePOJO> preferences;

    public ThemePOJO() {
        super();
    }

    public ThemePOJO(int themeId, String name) {
        super();
        this.themeId = themeId;
        this.name = name;
    }

    public int getID() {
        return themeId;
    }

    public void setID(int themeId) {
        this.themeId = themeId;
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
