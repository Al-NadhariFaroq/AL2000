package db;

import db.dao.SubscriberDAO;
import db.dao.ThemeDAO;
import db.entities.SubscriberEntity;
import db.entities.ThemeEntity;

public class TestBD {

    public static void main(String args[]) {
        ThemeDAO themeDAO = new ThemeDAO();

        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setThemeId(666);
        themeEntity.setTheme("essais");

        themeDAO.save(themeEntity);

        ThemeEntity themeEntity1 = themeDAO.get(666);
        themeEntity1.setTheme("test");
        themeDAO.update(themeEntity1);

        ThemeEntity themeEntity2 = themeDAO.get(666);
        themeDAO.delete(themeEntity2);

        SubscriberDAO subscriberDAO = new SubscriberDAO();
        SubscriberEntity subscriber = subscriberDAO.get(1);
        System.out.println(subscriberDAO.getAll());
        subscriberDAO.getAll().forEach(subscriber1 -> System.out.println(subscriber1.getEmail()));
        subscriber.getSubscriberCardsList().forEach(subscriberCards -> System.out.println(subscriberCards.getCardBalance()));
    }
}


