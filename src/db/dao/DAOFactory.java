package db.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAOFactory {
    private static final String persistenceUnitName = "AL2000";
    private static final EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName)
                                                                  .createEntityManager();

    /* DAO singletons */
    private static BluRayDAO blurayDAO;
    private static CardDAO cardDAO;
    private static MovieDAO movieDAO;
    private static ProfessionalDAO professionalDAO;
    private static RentalDAO rentalDAO;
    private static PreferenceDAO preferenceDAO;
    private static RoleDAO roleDAO;
    private static SubscribeCardDAO subscribeCardDAO;
    private static SubscriberDAO subscriberDAO;
    private static ThemeDAO themeDAO;

    public static BluRayDAO getBluRayDAO() {
        if (blurayDAO == null) {
            blurayDAO = new BluRayDAO(entityManager);
        }
        return blurayDAO;
    }

    public static CardDAO getCardDAO() {
        if (cardDAO == null) {
            cardDAO = new CardDAO(entityManager);
        }
        return cardDAO;
    }

    public static MovieDAO getMovieDAO() {
        if (movieDAO == null) {
            movieDAO = new MovieDAO(entityManager);
        }
        return movieDAO;
    }

    public static ProfessionalDAO getProfessionalDAO() {
        if (professionalDAO == null) {
            professionalDAO = new ProfessionalDAO(entityManager);
        }
        return professionalDAO;
    }

    public static RentalDAO getRentalDAO() {
        if (rentalDAO == null) {
            rentalDAO = new RentalDAO(entityManager);
        }
        return rentalDAO;
    }

    public static PreferenceDAO getRestrictionDAO() {
        if (preferenceDAO == null) {
            preferenceDAO = new PreferenceDAO(entityManager);
        }
        return preferenceDAO;
    }

    public static RoleDAO getRoleDAO() {
        if (roleDAO == null) {
            roleDAO = new RoleDAO(entityManager);
        }
        return roleDAO;
    }

    public static SubscribeCardDAO getSubscribeCardDAO() {
        if (subscribeCardDAO == null) {
            subscribeCardDAO = new SubscribeCardDAO(entityManager);
        }
        return subscribeCardDAO;
    }

    public static SubscriberDAO getSubscriberDAO() {
        if (subscriberDAO == null) {
            subscriberDAO = new SubscriberDAO(entityManager);
        }
        return subscriberDAO;
    }

    public static ThemeDAO getThemeDAO() {
        if (themeDAO == null) {
            themeDAO = new ThemeDAO(entityManager);
        }
        return themeDAO;
    }
}
