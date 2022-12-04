package db.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAOFactory {
    private static final String persistenceUnitName = "AL2000";
    private static final EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName)
                                                                  .createEntityManager();

    /* DAO singletons */
    private static BluRayDAO bluRayDAO;
    private static BluRayRentalDAO bluRayRentalDAO;
    private static CtrlSubDAO ctrlSubDAO;
    private static MovieDAO movieDAO;
    private static MovieThemeDAO movieThemeDAO;
    private static NonSubRentalDAO nonSubRentalDAO;
    private static PreferenceDAO preferenceDAO;
    private static RentalDAO rentalDAO;
    private static RoleDAO roleDAO;
    private static ScoreDAO scoreDAO;
    private static SubscriberDAO subscriberDAO;
    private static SubRentalDAO subRentalDAO;
    private static ThemeDAO themeDAO;

    public static BluRayDAO getBluRayDAO() {
        if (bluRayDAO == null) {
            bluRayDAO = new BluRayDAO(entityManager);
        }
        return bluRayDAO;
    }

    public static BluRayRentalDAO getBluRayRentalDAO() {
        if (bluRayRentalDAO == null) {
            bluRayRentalDAO = new BluRayRentalDAO(entityManager);
        }
        return bluRayRentalDAO;
    }

    public static CtrlSubDAO getCtrlSubDAO() {
        if (ctrlSubDAO == null) {
            ctrlSubDAO = new CtrlSubDAO(entityManager);
        }
        return ctrlSubDAO;
    }

    public static MovieDAO getMovieDAO() {
        if (movieDAO == null) {
            movieDAO = new MovieDAO(entityManager);
        }
        return movieDAO;
    }

    public static MovieThemeDAO getMovieThemeDAO() {
        if (movieThemeDAO == null) {
            movieThemeDAO = new MovieThemeDAO(entityManager);
        }
        return movieThemeDAO;
    }

    public static NonSubRentalDAO getNonSubRentalDAO() {
        if (nonSubRentalDAO == null) {
            nonSubRentalDAO = new NonSubRentalDAO(entityManager);
        }
        return nonSubRentalDAO;
    }

    public static PreferenceDAO getRestrictionDAO() {
        if (preferenceDAO == null) {
            preferenceDAO = new PreferenceDAO(entityManager);
        }
        return preferenceDAO;
    }

    public static RentalDAO getRentalDAO() {
        if (rentalDAO == null) {
            rentalDAO = new RentalDAO(entityManager);
        }
        return rentalDAO;
    }

    public static RoleDAO getRoleDAO() {
        if (roleDAO == null) {
            roleDAO = new RoleDAO(entityManager);
        }
        return roleDAO;
    }

    public static ScoreDAO getScoreDAO() {
        if (scoreDAO == null) {
            scoreDAO = new ScoreDAO(entityManager);
        }
        return scoreDAO;
    }

    public static SubscriberDAO getSubscriberDAO() {
        if (subscriberDAO == null) {
            subscriberDAO = new SubscriberDAO(entityManager);
        }
        return subscriberDAO;
    }

    public static SubRentalDAO getSubRentalDAO() {
        if (subRentalDAO == null) {
            subRentalDAO = new SubRentalDAO(entityManager);
        }
        return subRentalDAO;
    }

    public static ThemeDAO getThemeDAO() {
        if (themeDAO == null) {
            themeDAO = new ThemeDAO(entityManager);
        }
        return themeDAO;
    }
}
