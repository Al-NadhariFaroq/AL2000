package db.dao;

public class DAOFactory {

    public static BluRayDAO getBluRayDAO() {
        return BluRayDAO.getInstance();
    }

    public static BluRayRentalDAO getBluRayRentalDAO() {
        return BluRayRentalDAO.getInstance();
    }

    public static CtrlSubDAO getCtrlSubDAO() {
        return CtrlSubDAO.getInstance();
    }

    public static MovieDAO getMovieDAO() {
        return MovieDAO.getInstance();
    }

    public static MovieThemeDAO getMovieThemeDAO() {
        return MovieThemeDAO.getInstance();
    }

    public static NonSubRentalDAO getNonSubRentalDAO() {
        return NonSubRentalDAO.getInstance();
    }

    public static PreferenceDAO getRestrictionDAO() {
        return PreferenceDAO.getInstance();
    }

    public static RentalDAO getRentalDAO() {
        return RentalDAO.getInstance();
    }

    public static RoleDAO getRoleDAO() {
        return RoleDAO.getInstance();
    }

    public static ScoreDAO getScoreDAO() {
        return ScoreDAO.getInstance();
    }

    public static SubRentalDAO getSubRentalDAO() {
        return SubRentalDAO.getInstance();
    }

    public static SubscriberDAO getSubscriberDAO() {
        return SubscriberDAO.getInstance();
    }

    public static ThemeDAO getThemeDAO() {
        return ThemeDAO.getInstance();
    }
}
