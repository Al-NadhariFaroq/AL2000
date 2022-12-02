package db;

import db.dao.DAOFactory;
import db.dao.SubscriberDAO;
import db.dao.ThemeDAO;
import db.pojo.SubscriberPOJO;
import db.pojo.ThemePOJO;

public class CRUDMethodsTest {

    public static void main(String[] args) {
        ThemeDAO themeDAO = DAOFactory.getThemeDAO();

        ThemePOJO themePOJO1 = new ThemePOJO();
        themePOJO1.setThemeId(666);
        themePOJO1.setTheme("essais");
        themeDAO.create(themePOJO1);

        ThemePOJO themePOJO2 = themeDAO.read(666);
        themePOJO2.setTheme("test");
        themeDAO.update(themePOJO2);

        ThemePOJO themePOJO3 = themeDAO.read(666);
        themeDAO.delete(themePOJO3);

        SubscriberDAO subscriberDAO = DAOFactory.getSubscriberDAO();
        SubscriberPOJO subscriberPOJO = subscriberDAO.read(1);
        subscriberPOJO.getSubscribeCardsList()
                      .forEach(subscribeCard -> System.out.println(subscribeCard.getCardBalance()));
    }
}


