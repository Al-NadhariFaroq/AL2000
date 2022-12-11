package db;

import db.dao.DAO;
import db.dao.DAOFactory;
import db.pojo.ThemePOJO;

import java.util.List;
import java.util.Objects;

public class CRUDMethodsTest {

    public static void main(String[] args) {
        testNextId();
        testThemeDAO();
    }

    private static void testNextId() {
        boolean success = true;

        System.out.println("TEST NEXT ID:");
        for (DAO<?> dao : DAOFactory.ALL_DAO) {
            List<?> entities = dao.readAll();
            int id = dao.getNextId();
            success = success && id == entities.size() + 1;

            System.out.print("   " + dao.getClass().getSimpleName() + ": ");
            System.out.println(id == entities.size() + 1 ? "succeed" : "failed");
        }
        System.out.println(success ? "SUCCESS" : "FAILURE");
    }

    private static void testThemeDAO() {
        System.out.println("TEST THEME DAO:");

        List<ThemePOJO> themes = DAOFactory.getThemeDAO().readAll();
        System.out.println("    nb of themes: " + themes.size());

        int themeId = DAOFactory.getThemeDAO().getNextId();
        ThemePOJO theme = new ThemePOJO(themeId, "essais");

        DAOFactory.getThemeDAO().create(theme);
        theme = DAOFactory.getThemeDAO().read(themeId);
        System.out.println("    new theme ID: " + theme.getID() + " (" + theme.getName() + ")");

        theme.setName("test");
        DAOFactory.getThemeDAO().update(theme);
        theme = DAOFactory.getThemeDAO().read(themeId);

        DAOFactory.getThemeDAO().delete(theme);

        if (theme.getID() == themes.size() + 1 && Objects.equals(theme.getName(), "test")) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILURE");
        }
    }
}
