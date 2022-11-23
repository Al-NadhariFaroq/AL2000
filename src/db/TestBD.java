package db;

import db.dao.ThemeDAO;
import db.entities.Theme;

public class TestBD {

    public static void main(String args[]) {
        ThemeDAO themeDAO = new ThemeDAO();

        Theme theme = new Theme();
        theme.setThemeId(1);
        theme.setTheme("test");

        themeDAO.save(theme);

        Theme theme1 = themeDAO.get(1);
        theme1.setTheme("essais");
        themeDAO.update(theme1);

        Theme theme2 = themeDAO.get(1);
        themeDAO.delete(theme2);
    }
}


