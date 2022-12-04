package db;

import db.dao.DAOFactory;
import db.dao.ThemeDAO;
import db.pojo.ThemePOJO;

public class CRUDMethodsTest {

    public static void main(String[] args) {
        ThemeDAO themeDAO = DAOFactory.getThemeDAO();

        ThemePOJO themePOJO1 = new ThemePOJO();
        themePOJO1.setName("essais");
        themeDAO.create(themePOJO1);

        ThemePOJO themePOJO2 = themeDAO.read(666);
        themePOJO2.setName("test");
        themeDAO.update(themePOJO2);

        ThemePOJO themePOJO3 = themeDAO.read(666);
        themeDAO.delete(themePOJO3);
    }
}
