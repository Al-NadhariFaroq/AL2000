package db.pojo;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy="theme", cascade = CascadeType.ALL)
    private List<MovieThemePOJO> movieThemePOJOList;

    @OneToMany(mappedBy="theme", cascade = CascadeType.ALL)
    private List<PreferencePOJO> preferencePOJOList;
    public ThemePOJO() {

    }

    public ThemePOJO(int themeId,String name) {
        this.themeId = themeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String theme) {
        this.name = theme;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
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
