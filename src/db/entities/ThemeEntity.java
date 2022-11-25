package db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "THEMES", schema = "ALNADHAF", catalog = "")
public class ThemeEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "THEME_ID")
    private int themeId;
    @Basic
    @Column(name = "THEME")
    private String theme;

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ThemeEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThemeEntity that = (ThemeEntity) o;
        return themeId == that.themeId && Objects.equals(theme, that.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeId, theme);
    }
}
